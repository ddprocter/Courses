package lifetracker;

import java.io.Serializable;

public enum TrackerEnum implements Serializable {
	
	// come back to this later and evaluate whether this is useful
	
	CLICKER {
	
		public String getType(){
			return "Clicker";
		}
		
	},
	COUNTTRACKER{
		public String getType(){
			return "Count Tracker";
		}
		
		
	},
	ACTIONTRACKER{
		public String getType(){
			return "Action Tracker";
		}
		
		
	};
	
	public abstract String getType();
	
}
