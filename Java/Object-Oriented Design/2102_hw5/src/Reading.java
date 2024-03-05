
public class Reading {
	
	private Time time;
	private double temp;
	private double rainfall;
	
	public Reading(Time time, double temp, double rainfall){
		this.time = time;
		this.temp = temp;
		this.rainfall = rainfall;
	}

	public double getTemp() {
		return this.temp;
	}

	public double getRainfall() {
		return this.rainfall;
	}

}
