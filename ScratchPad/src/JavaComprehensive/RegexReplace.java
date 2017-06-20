package JavaComprehensive;

public class RegexReplace {

	public static void main(String[] args) {
		 String[] tests = {
			        "  leading    spaces,   trailing    spaces , , , spaces  ,  more spaces  ",          // [x]
			        "  1   2   3  ",  // [1 2 3]
			        "",               // []
			        "   ",            // []
			    };
			    for (String test : tests) {
			        
			            //String newStr = test.replaceAll("^ +| +$|( )+", " ");
			    	    
			    		String newStr = test.replaceAll(" +", " ");
			    		String newStr2 = newStr.replaceAll(" , +| ,+|, +",",");
			            
			            System.out.println(newStr2);
			       
			    }

	}

}
