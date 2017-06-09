package lifetracker;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class UserTrackerMapController {
	
	private LinkedHashMap<String, Tracker> userTrackerMap;
	private User user;
	private String trackerName;
	private Tracker tracker;
	private String filePath = "./userMapConfigs";
	private String filename;
	private boolean newFile;
	private File userFile;
	
	public UserTrackerMapController(User user) {
		
		this.user = user;
		this.filename = filePath + "/" + user.getUserLogin() + ".config";
		userFile = new File(filename);
		
		if ( userFile.exists() && userFile.canRead() ) {
			
			try {
				FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
				userTrackerMap = (LinkedHashMap<String, Tracker>) objIn.readObject();
				fileIn.close();
				newFile = false;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} else {
			userTrackerMap = new LinkedHashMap<String,Tracker>();
		}
	
				
	}
	
	public ArrayList<String> getUserTrackerList(){
		
		ArrayList<String> list = new ArrayList<String>();
		
		for( Map.Entry<String,Tracker> entry : userTrackerMap.entrySet()){
			  String key = entry.getKey();
			  String value = entry.getValue().getType().getType();
			  
			  list.add("Name: " + key + " Type: " + value);
			 
		}
		return list;
		
		
	}
	
	public LinkedHashMap<String, Tracker>  getUserTrackerMap(){
		return userTrackerMap;
		
	}
		
	public boolean commit(){
		if ( userFile.exists() ) {
			userFile.delete();
		}
		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(userTrackerMap);
			fileOut.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
			
	}
	
	public boolean addTracker(Tracker tracker){
		if (! userTrackerMap.containsKey(tracker.getName())) {
			userTrackerMap.put(tracker.getName(), tracker);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public Tracker getTracker(String name){
		
		return userTrackerMap.get(name);
	
	}

	public void removeTracker(Tracker name){
		userTrackerMap.remove(name);
		
	}
}
