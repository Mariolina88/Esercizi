package org.geoframe.first;

public class LinearEquation_1 {
	public double a=1,b=-2;
	
	public double solution() {
		double sol;
		sol=-b/a;
		return sol;
	}

	public static void main(String[] args) {
		System.out.println("Linear Equation 1 Solution");
		LinearEquation_1 a=new LinearEquation_1();
		System.out.println("The solution is: "+a.solution());
		System.out.println("End of computation");

	}

}
