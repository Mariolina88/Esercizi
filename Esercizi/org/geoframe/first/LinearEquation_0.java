package org.geoframe.first;

public class LinearEquation_0 {
	public static double a=1,b=-2;
	
	public static double solution() {
		double sol;
		sol=-b/a;
		return sol;
	}

	public static void main(String[] args) {
		System.out.println("Linear Equation 0 Solution");
		System.out.println("The solution is: "+solution());
		System.out.println("End of computation");

	}

}
