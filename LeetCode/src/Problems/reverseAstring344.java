package Problems;

public class reverseAstring344 {
	public String reverseString(String s) {
		StringBuilder st = new StringBuilder();
		
		for(int i = s.length() - 1; i >= 0; i--){
			st.append(s.charAt(i));
		}
		
		return st.toString();
        
    }

}
