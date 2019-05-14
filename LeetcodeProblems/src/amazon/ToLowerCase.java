package amazon;

public class ToLowerCase {
	
	
	public static void main(String args[]) {
		System.out.println("TEST");
		String res = toLowerCase("LOVELY");
		System.out.println(res);
	}
	
	public static String toLowerCase(String str) {	
		char[] s = str.toCharArray();   
        for(int i = 0; i < s.length; i++)
        {
            if('A' <= s[i] && s[i] <= 'Z'){
                s[i] = (char) (s[i] + ('a' - 'A'));
            }
        }
        return new String(s);
    }

}
