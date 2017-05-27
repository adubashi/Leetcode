
public class BoyerMoore {
	private int[] right;
	private String pattern;
	
	
	
	public BoyerMoore(String pat){
		this.pattern = pat;
		int M = pat.length();
		int R = 256;
		right = new int[R];
		
		//Initialize the right table
		for(int c = 0; c < R; c++){
			right[c] = -1;
		}
		//
		for(int j = 0; j < M; j++){
			right[pat.charAt(j)] = j;
		}
	}

}