package lifetracker;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Report {
	private Tracker tracker;
	private ReportStatusEnum status;
	private LinkedHashMap<Date,Integer> reportCountData; 
	private TreeMap<String,TokenCountsByDate<Date,Integer>> reportTokenData;
	private String name;
	
	public Report(Tracker tracker){
		this.tracker = tracker;
		this.status = ReportStatusEnum.INIT;
		this.reportCountData = new LinkedHashMap<Date,Integer>();
		this.reportTokenData = new TreeMap<String,TokenCountsByDate<Date,Integer>>();
		
	}
	
	public TrackerEnum getTrackerType(){
		return tracker.getType();
	}
	
	public String getName(){
		return tracker.getName();
		
	}
	
	public ReportStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ReportStatusEnum status) {
		this.status = status;
	}	
	
	public Tracker getTracker() {
		return tracker;
	}


	public LinkedHashMap<Date, Integer> getReportCountData() {
		return reportCountData;
	}


	public TreeMap<String, TokenCountsByDate<Date, Integer>> getReportTokenData() {
		return reportTokenData;
	}


	public void addReportByDayCount(Date date, Integer count){
		// check if date present in map
		if ( reportCountData.containsKey(date)){
			// if yes, add to its count
			int priorCount = reportCountData.get(date);
			reportCountData.put(date, priorCount+count);
		} else {
			// if not, add the date
			reportCountData.put(date, count);
		}
		// report has at least one good metric, report ok
		this.setStatus(ReportStatusEnum.OK);
	}
	
	public void addTokenByDayCount(String token, Date date, Integer count){
		if (reportTokenData.containsKey(token)) {
			TokenCountsByDate<Date,Integer> tokenCountsByDate = reportTokenData.get(token);
			if (tokenCountsByDate.containsKey(date)) {
				int priorCount= tokenCountsByDate.get(date);
				tokenCountsByDate.put(date, priorCount+count);
			} else {
				tokenCountsByDate.put(date, count);
			}
		} else {
			TokenCountsByDate<Date,Integer> tokenCountsByDate = new TokenCountsByDate<Date,Integer>();
			tokenCountsByDate.put(date, count);
			reportTokenData.put(token, tokenCountsByDate);
		}
		// report has at least one good metric, report ok
		this.setStatus(ReportStatusEnum.OK);
		
	}


	public class TokenCountsByDate<Date, Integer> extends LinkedHashMap<Date,Integer> {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private TokenCountsByDate(){
			
		}
		
		
	}

}
