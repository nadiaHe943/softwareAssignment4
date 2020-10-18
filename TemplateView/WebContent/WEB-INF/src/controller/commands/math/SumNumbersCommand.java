package controller.commands.math;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import view.math.HelperMath;

import model.math.SimpleMath;

import controller.commands.AbstractCommand;

public class SumNumbersCommand extends AbstractCommand {

	@Override
	public void process() throws ServletException, IOException {
		
		//retrieve parameters from request
		double a = Double.parseDouble(request.getParameter("a"));
		double b = Double.parseDouble(request.getParameter("b"));
		
		//obtain reference to model object
		SimpleMath simpleMath = new SimpleMath();
		
		//send request to the model		
		double total = simpleMath.sum(a, b);
		
		// create helper object
		HelperMath hm = new HelperMath(total);
		
		//select next view
		request.setAttribute("helperMath", hm);
		
		sc.getRequestDispatcher("/showResult.jsp").forward(request, response);	}
}
