package binarysearch;

public class GuessGame {
	
	public int guessNumber(int n) {
        
        int start = 1;
        int end = n;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            int guessResult = guess(mid);
            
            if(guessResult == 0){
                return mid;
            }
            
            if(guessResult == 1){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return -1;
        
    }

}
