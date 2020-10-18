package controller.bookPage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import model.library.Book;


/**
 * Servlet implementation class MathPageController
 */
@WebServlet("/BookPageController")
public class BookPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String FS = System.getProperty("file.separator");
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = Book.createDefaultBook();
		
		response.setContentType("text/html; charset=UTF-8");
		//retrieve ref to output stream
		PrintWriter out = response.getWriter();
		
		String path = getServletContext().getRealPath("") + FS + "libraryPages" + FS;
        
		String xslTemplateFile = path + "bookPage.xsl"; //transformation
		String xslRenderFile = path + "bookRendering.xsl"; //transformation
        String xmlData = book.toXML();	//target
        
        //creation of a transformer that works base on a xsl file
		TransformerFactory tFactory =
				TransformerFactory.newInstance();
			Transformer transformerPage = null;
			Transformer transformerRender = null;
			try {
				transformerPage = tFactory.newTransformer(new StreamSource(xslTemplateFile));
				transformerRender = tFactory.newTransformer(new StreamSource(xslRenderFile));
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				//the implementation should forward to 
				//a suitable error page
				//e.printStackTrace();
			}

			//HTML page header
			out.println("<HTML><BODY>");
			
			// Perform the transformation.
				try {
					
					ByteArrayOutputStream tmpStream = new ByteArrayOutputStream();
					
					transformerPage.transform(new StreamSource(new ByteArrayInputStream(xmlData.getBytes())),
							new StreamResult(tmpStream)); 
					transformerRender.transform(new StreamSource(new ByteArrayInputStream(tmpStream.toString().getBytes())),
			                  new StreamResult(out));
//					 getServletContext().log(tmpStream2.toString());
					
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					//the implementation should forward to 
					//a suitable error page
					//e.printStackTrace();
				}

				//go back button
				out.println("Go <a href=\"libraryPages/index.jsp\">back</a> ");

				//HTML page footer
				out.println("</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
