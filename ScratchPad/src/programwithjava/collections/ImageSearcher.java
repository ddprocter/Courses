package programwithjava.collections;

import java.io.*;
import java.util.*;

public interface ImageSearcher extends Serializable {
 Collection<String> extractTags(String s); // extract individual tags	
 
 // adds new photo to database
 void addPhoto(String filename, Photo p); 

 // get the photo with this filename
 Photo getPhoto(String filename); 	

 // get all photos that have all of the tags in set s
 Collection<File> getPhotosContainingAllTags(Set<String> s);	

 // returns name of file to which object is serialized
 File getSerializationFileName();
}
