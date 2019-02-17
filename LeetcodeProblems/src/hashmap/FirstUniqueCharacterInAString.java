package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

public class FirstUniqueCharacterInAString {
	public static int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		//Create a character count map
		for(int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				int val = map.get(s.charAt(i));
				map.put(s.charAt(i), val + 1);
			} else{
               map.put(s.charAt(i), 1); 
            }
		}
		
		//Iterate through the string again
		for(int i = 0; i < s.length(); i++) {
			int val = map.get(s.charAt(i));
			if(val == 1) {
				return i;
			}
		}
		return -1;     
    }

}
