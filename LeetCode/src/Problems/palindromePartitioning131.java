package Problems;
import java.util.List;
import java.util.ArrayList;

public class palindromePartitioning131 {
	//DFS
	
	public  static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (s == null || s.length() == 0) {
			return result;
		}
		List<String> partition = new ArrayList<String>();
		addPalindrome(s,0,partition,result);
		return result;
		
	}
	
	private static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
	 
			left++;
			right--;
		}
		return true;
	}
	
	private static  void addPalindrome(String s, int start, List<String> partition,
			List<List<String>> result) {
		//stop condition
		if (start == s.length()) {
			List<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
		for(int i = start +1; i <= s.length(); i++){
			String str = s.substring(start,i);
			if(isPalindrome(str)){
				partition.add(str);
				addPalindrome(s,i,partition,result);
				partition.remove(partition.size()-1);
			}
			
		}	
	}

}
