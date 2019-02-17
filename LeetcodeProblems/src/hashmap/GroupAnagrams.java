package hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagrams(strs);

	}
	
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<Map<Character,Integer>, List<String>> map = new HashMap<Map<Character,Integer>, List<String>>();
		for(int i = 0; i < strs.length; i++) {
			String currentString = strs[i];
			Map<Character,Integer>  characterMap = getCharacterCountMap(currentString);
			
			if(map.containsKey(characterMap)){
	            map.get(characterMap).add(currentString);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(currentString);
	            Map<Character,Integer>  characterMap2 = getCharacterCountMap(currentString);
	            map.put(characterMap2, al);
	        }
			
		}
		
		for (List<String> value : map.values()) {
		    result.add(value);
		}
		System.out.println(result);
		
		return result;
    }
	
	public static Map<Character,Integer> getCharacterCountMap(String str){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++) {
			Character c = Character.valueOf(str.charAt(i));
			if(map.containsKey(c)) {
			  int count = map.get(c);
			  map.put(c, count + 1);
			} else {
			  map.put(c, 1);
			}
		}
		return map;
	}

}
