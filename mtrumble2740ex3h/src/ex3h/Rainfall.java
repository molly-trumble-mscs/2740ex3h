package ex3h;

public class Rainfall {
	private double[] rainfallArray;
	
	public Rainfall(double [] rArray) {
		rainfallArray = new double[rArray.length];
		
		for(int i=0; i < rArray.length; i++)
			this.rainfallArray[i] = rArray[i];
	}
	
	public Rainfall(String [] rStrArray) {
		rainfallArray = new double[rStrArray.length];
		
		for(int i=0; i < rStrArray.length; i++)
			this.rainfallArray[i] = Double.parseDouble(rStrArray[i]);
	}
	
	public double getTotal() {
		double total=0;
		
		for(double value : this.rainfallArray)
			total += value;
		
		return total;
	}
	
	public double getAverage() {
		return this.getTotal()/this.rainfallArray.length;
	}

	public double getHighest() {
		double highest = this.rainfallArray[0];
		
		for(int i=0; i < this.rainfallArray.length; i++){
			if (this.rainfallArray[i] > highest)
				highest = this.rainfallArray[i];
		}
		
		return highest;
	}
	
	public double getLowest() {
		double lowest = this.rainfallArray[0];
		
		for(int i=0; i < this.rainfallArray.length; i++){
			if (this.rainfallArray[i] < lowest)
				lowest = this.rainfallArray[i];
		}
		return lowest;
	}

}
