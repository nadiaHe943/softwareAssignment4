package view.math;


public class HelperMath {

	double number;
	
	public HelperMath(double number) {
		this.number = number;
	}
	
	public String getResult() {
		String result = "%.2f";
		result = String.format(result,number);
		
		return result;
	}
}
