package _03_Intro_to_Enums;

public enum StatesOfMatter {
	
	SOLID(0), LIQUID(25.55), GAS(100);
	
	double celsiusTemp;
	
	StatesOfMatter(double celsiusTemp) {
		this.celsiusTemp = celsiusTemp;
	}
	
	public double convertToFarenheit(double c) {
		double farenheit = (c * (9/5) + 32);
		
		return farenheit;
	}
}
