package Collections;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import programwithjava.collections.Photo;

public class PhotoFinder {
	
	private HashMap<String, Photo> nameToTagsMap;
	private HashMap<String, TreeSet<File>> tagToNamesMap;
	
	public Photo getPhoto(String name){
		if (nameToTagsMap.containsKey(name)){
			Photo p = nameToTagsMap.get(name);
			return p;
		} else{
			return null;
		}
		
	}
	
	
	
	
	
	
	
	public void addPhoto(String name, Photo p){
		nameToTagsMap.put(name,  p);
		for (String tag : p.getTags()) {
			// get the TreeSet from the hashMap if it already exists
			TreeSet<File> filenameSet = tagToNamesMap.get(tag);
			// if it doesn't exist, create it
			if (filenameSet == null) { 
				filenameSet = new TreeSet<File>();
			}
			filenameSet.add(p.getFilename());
			tagToNamesMap.put(tag,  filenameSet);
				
		}
		
	}
	
	public TreeSet<File> getPhotosContainingAllTags(Set<String> s) {
		String tag;
		TreeSet<File> photos = new TreeSet<File>();
		Iterator<String> tagIterator = s.iterator();
		while (tagIterator.hasNext() ) {
			tag = tagIterator.next();
			if (tagToNamesMap.containsKey(tag)){
				if (photos.isEmpty()) {
					// if empty, initialize
					// but must use clone, otherwise 
					// photos is permanently reference to = tagToNamesMap, 
					// they are the same object
					photos = (TreeSet<File>) tagToNamesMap.get(tag).clone();
					
				} else {
					photos.retainAll(tagToNamesMap.get(tag));
					// intersection of the two 
				}
			} else {
				photos.clear();
				// if any of the tags is not found, all the photos must be removed
				break;
			}
		}
		return photos;
		
		
	}
	
	public LinkedHashSet<String> extractTags(String s){
		int index = 0;
		StringBuilder sb = new StringBuilder();
		LinkedHashSet<String> tags = new LinkedHashSet<String>();
		
		while (index != s.length()) {
			// skip leading blanks, tabs, semicolons, and commas
			char ch = s.charAt(index);
			while (ch == ' ' || ch == '\t' || ch == ',' || ch == ';' ) {
				sb.append(ch);
				if (++index == s.length())
					break;
				ch = s.charAt(index);
			}
			if (sb.length() > 0 ) 
				tags.add(sb.toString());
				sb.delete(0, sb.length());
			
		}
		
		return tags;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
