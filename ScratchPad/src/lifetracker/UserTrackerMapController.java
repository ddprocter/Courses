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
		
		// fetch the tracker configuration file for user
		if ( userFile.exists() && userFile.canRead() ) {
		// if there is already a tracker configuration for this user, fetch it	
			try {
				FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
				userTrackerMap = (LinkedHashMap<String, Tracker>) objIn.readObject();
				fileIn.close();
				//newFile = false; // don't think we need this
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} else {
			// otherwise we just create a new blank one
			userTrackerMap = new LinkedHashMap<String,Tracker>();
			
		}
	
				
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

	public boolean removeTracker(String trackerName){
		if ( userTrackerMap.containsKey(trackerName)) {
			Tracker trackerToRemove = userTrackerMap.get(trackerName);
			trackerToRemove.deleteDataFile();
			userTrackerMap.remove(trackerName);
			return true;
		} else {
			return false;
		}
			
		
		
	}
}
