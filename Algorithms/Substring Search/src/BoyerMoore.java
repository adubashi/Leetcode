
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
		//Get last character instance from the right
		for(int j = 0; j < M; j++){
			right[pat.charAt(j)] = j;
		}
	}
	
	public int search(String txt){
		int M = pattern.length();
		int N = txt.length();
		int skip;
		
		for(int i = 0; i <= N-M; i++){
			//Check the skip position
			skip = 0;
			for(int j = M-1; j >= 0; j--){
				//We have a mismatch
				if(txt.charAt(i+j) != pattern.charAt(j)){
					skip = j - right[txt.charAt(i+j)];
					
					if(skip < 1){
						skip = 1;
					}
					//If we have a mismatch break out
					break;
				}
				if(skip == 0){
					return i;
				}
			}
			
		}
		//Pattern not found;
		return N;
	}

}
