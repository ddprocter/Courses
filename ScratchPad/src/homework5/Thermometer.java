package homework5;

import java.io.Serializable;

public class Thermometer implements Serializable {
	
	private String type; // type - mercury or digital
	private int temperature;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	

	

}
