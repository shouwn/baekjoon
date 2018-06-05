package eq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

    // Complete the missingWords function below.
    static String[] missingWords(String s, String t) {

		Pattern pattern = Pattern.compile("[A-Za-z]+");
		
    	
    	String[] arr = t.split(" ");
    	
    	for(String str : arr) 
    		s = s.replaceAll(str, "");
    	
    	List<String> list = new ArrayList<>();
    	
    	Matcher matcher = pattern.matcher(s);
    	
    	while(matcher.find())
    		list.add(matcher.group(0));
    	
    	return list.toArray(new String[0]);
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	String s = "a b c d";
    	
    	s = s.replaceAll("b", "");
    	
    	System.out.println(s);
    }
}
