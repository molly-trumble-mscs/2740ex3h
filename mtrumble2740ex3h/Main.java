package ex3h;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] dblRainfall = {
				2.4, 3.2, 5.3, 5.2, 6.3, 2.1,
				4.2, 6.2, 7.1, 3.6, 2.5, 5.3 };
		String[] strRainfall = {
				"2.4", "3.2", "5.3", "5.2", "6.3", "2.1",
				"4.2", "6.2", "7.1", "3.6", "2.5", "5.3" };
		DecimalFormat fmt = new DecimalFormat("#0.0");
		
		Rainfall rainfall = new Rainfall(dblRainfall);
		System.out.println("Rainfall Total:   " + fmt.format(rainfall.getTotal()));
		System.out.println("Rainfall Average:   " + fmt.format(rainfall.getAverage()));
		System.out.println("Rainfall Highest:   " + fmt.format(rainfall.getHighest()));
		System.out.println("Rainfall Lowest:   " + fmt.format(rainfall.getLowest()));
		System.out.println();
		
		rainfall = new Rainfall(strRainfall);
		System.out.println("Rainfall Total:   " + fmt.format(rainfall.getTotal()));
		System.out.println("Rainfall Average:   " + fmt.format(rainfall.getAverage()));
		System.out.println("Rainfall Highest:   " + fmt.format(rainfall.getHighest()));
		System.out.println("Rainfall Lowest:   " + fmt.format(rainfall.getLowest()));
		System.out.println();
	}

}
