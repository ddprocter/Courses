package lifetracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tracker implements Serializable {
	private String name;
	private TrackerEnum type;
	private User user; 
	private static String filePath = "./userData";
	private String filename;
	//private File trackerFile;
	
	
	Tracker(String name, User user, TrackerEnum type){
		//name.trim(); don't think we need this if we trim before call constructor
		this.name = name;
		this.type = type;
		this.user = user;
		this.filename = filePath + "/" + user.getUserLogin() 
		+ "." + this.name + ".dat";
		
		
	}
	
	public static Report reportByDay(Tracker tracker) {
		
		Report report = new Report(tracker);
		//String filename = filePath + "/" + tracker.getUser().getUserLogin() 
		//+ "." + tracker.getName() + ".dat";
		// believe this is redundant, member variable filename
		
		File dataFile = new File(tracker.getFilename());
		
		if (! dataFile.exists() ){
			report.setStatus(ReportStatusEnum.NODATA);
			return report;
		}
		
		try {
			FileReader fr = new FileReader(tracker.getFilename()); 
			BufferedReader bufferedReader = new BufferedReader(fr);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] data = line.split("\\|", 4);
				// .dat file is in the format:
				// <dateTime>|trackername|trackertype|count
				
				// get the date, scrub the time
				Date date = new SimpleDateFormat("yyyyMMdd:HH:mm:ss").parse(data[0]);
				date = removeTime(date);
				
				// verify tracker name as expected
				if (! data[1].equals(tracker.getName())){
					report.setStatus(ReportStatusEnum.ERROR);
					return report;
				}
				
				// to do 
				// verify tracker type as expected
				
				
				if( tracker.getType() == TrackerEnum.ACTIONTRACKER) {
					String tokens = data[3];
					String[] tokenData = tokens.split("\\s");
					
					for (String t:tokenData){
						report.addTokenByDayCount(t, date, 1);
					}
					
				} else {
					int count =  Integer.parseInt(data[3]);
					report.addReportByDayCount(date, count);
				}
			}
			
		} catch (IOException e) {
			report.setStatus(ReportStatusEnum.ERROR);
			e.printStackTrace();
			return report;
			
		}
		catch (ParseException e) {
			report.setStatus(ReportStatusEnum.ERROR);
			e.printStackTrace();
			return report;
		}
		
		return report;
	
		
	}
	
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	//public File getTrackerFile() {
	//	return trackerFile;
	//}

	//public void setTrackerFile(File trackerFile) {
	//	this.trackerFile = trackerFile;
	//}

	public void track(String amount){
		
		String dataString = getCurrentDate()+ "|" +  this.getName() + "|"+ this.getType() + "|" + amount + "\n";
		
		File trackerFile = new File(filename);
		if (! trackerFile.exists()) {
			try {
				trackerFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter dataWriter = new FileWriter(filename, true);
			dataWriter.write(dataString);
			dataWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//public  void setName(String name){
	//	this.name = name;
	//};
	
	public String getName(){
		return this.name;
		
	}
	
	//public  void setType(TrackerEnum type){
	//	this.type = type;
	//};
	
	public TrackerEnum getType(){
		return this.type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	private String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd:HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date); 
	}
	
	public static Date removeTime(Date date) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.set(Calendar.HOUR_OF_DAY, 0);
	        cal.set(Calendar.MINUTE, 0);
	        cal.set(Calendar.SECOND, 0);
	        cal.set(Calendar.MILLISECOND, 0);
	        return cal.getTime();
	}

	public void deleteDataFile() {
		File trackerFile = new File(filename);
		if ( trackerFile.exists()) {
			try {
				trackerFile.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
		
	}



}