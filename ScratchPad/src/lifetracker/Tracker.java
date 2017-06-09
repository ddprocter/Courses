package lifetracker;

import java.io.Serializable;

public class Tracker implements Serializable {
	private String name;
	private TrackerEnum type;
	
	Tracker(String name, TrackerEnum type){
		this.name = name;
		this.type = type;
		
	}
	
	public  void setName(String name){
		this.name = name;
	};
	
	public String getName(){
		return this.name;
		
	}
	
	public  void setType(TrackerEnum type){
		this.type = type;
	};
	
	public TrackerEnum getType(){
		return this.type;
		
	}



}
