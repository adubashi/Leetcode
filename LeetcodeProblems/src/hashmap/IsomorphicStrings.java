package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicStrings {
	
	public static boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		int i = 0;
		while(i < s.length()) {
			Character temp1 = s.charAt(i);
			Character temp2 = t.charAt(i);
			if(map.containsKey(temp1)) {
				Character val = map.get(temp1);
				//Character is not equal to expected mapping
			   if(!val.equals(temp2)) {
				   return false;
			   }
			} else {
				//Character is already mapped
				if(map.containsValue(temp2)) {
					return false;
				}
				map.put(temp1, temp2);
			}
			i++;
		}
		return true;
    }

}
