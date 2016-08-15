package Problems;
import java.util.*;
public class isomorphicStrings205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isIsomorphic("egg","add"));

	}
	public static boolean isIsomorphic(String s, String t) {
		
		if(s.length() != t.length()){
			return false;
		}
		Map<Character,Character> map = new HashMap<Character,Character>();
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			char ch1 = t.charAt(i);
			//If the key maps to a different value
			if(map.containsKey(ch)) {
				if(map.get(ch) != ch1){
					return false;
				}
			} else {
				//Value is already mapped
				if(map.containsValue(ch1)){
					return false;
				}
				map.put(ch, ch1);
			}
			
		}
		return true;
	}

}
