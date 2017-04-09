package com.programwithjava.collections;
import java.util.*;
import java.io.*;

public class Photo implements Serializable {
  private File filename; 		// complete filename including path
  private Collection<String> tags; 	// tags 

  public Photo(File name, Collection<String> t) {
    filename = name;
    tags = t;
  }
	
  public Collection<String> getTags() {
    return tags;
  }
	
  public File getFilename() {
    return filename;
  }
}
