package Problems;

public class reverseVowelsOfaString345 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isVowel(char c) {
		  return "AEIOUaeiou".indexOf(c) != -1;
	}
	
	public static void swap(char[] arr, int i, int j){
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}
	
	
	public static String reverseVowels(String s){
		int front = 0;
		int back = s.length() - 1;
		
		char[] chars = s.toCharArray();
		
		while(front < back){
			//If the front is not a vowel move to the next iteration
			if(!isVowel(chars[front])){
				front++;
				continue;
			}
			//If the back is not a vowel move to the next iteration
			if(!isVowel(chars[back])){
				back--;
				continue;
			}
			
			swap(chars,front,back);
			front++;
			back--;
		}
		return new String(chars);
	}

}
