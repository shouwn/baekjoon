package eq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
	
	static final Map<Integer, String> map = new HashMap<>();
	
	static {
		map.put(1, "I");
		map.put(2, "II");
		map.put(3, "III");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(6, "VI");
		map.put(7, "VII");
		map.put(8, "VIII");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
	}
	
    // Complete the romanizer function below.
    static String[] romanizer(int[] numbers) {
    	Integer[] keys = map.keySet().toArray(new Integer[0]);
    	Arrays.sort(keys, Collections.reverseOrder());
    	
    	List<String> list = new ArrayList<>();
    	
    	StringBuilder str = new StringBuilder();
    	
    	for(int i = 0; i < numbers.length; i++) {
    		int number = numbers[i];
    		
    		for(int n : keys) {
    			int x = number / n;
    			number %= n;
    			
    			for(int j = 0; j < x; j++)
    				str.append(map.get(n));
    			
    			if(number == 0)
    				break;
    		}
    		
    		list.add(str.toString());
    		str = new StringBuilder();
    	}
    	
    	return list.toArray(new String[0]);
    	
    }
	
}
