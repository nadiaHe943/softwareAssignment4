package controller.mathPage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.math.SimpleMath;

/**
 * Servlet implementation class MathPageController
 */
@WebServlet("/MathPageController")
public class MathPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SimpleMath simpleMath;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MathPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		//instantiate a model object for the application (shared among users of this same servlet)
		simpleMath = new SimpleMath();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve parameters
		double a = Double.parseDouble(request.getParameter("a"));
		double b = Double.parseDouble(request.getParameter("b"));
		
		//send request to the model
		double total = simpleMath.sum(a, b);
		int numOperations = simpleMath.getNumOperations();
		
		//select next view
		request.setAttribute("total", total);
		request.setAttribute("numOperations", numOperations);
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/mathPages/showResult.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
