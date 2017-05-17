package Company1Social;
import java.util.*;
public class KMPalgorithm {
	
	public static int[] computeLPSArray(String pat, int M)
    {
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;
        int[] lps = new int[M];
        lps[0] = 0;  // lps[0] is always 0
         
        // the loop calculates lps[i] for i = 1 to M-1
        while(i<M)
        {
            if(pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[len] = len;
                i++;
            } else { 
            	// (pat[i] != pat[len]) 
                if(len != 0) {
                    // This is tricky. Consider the example 
                    // AAACAAAA and i = 7.
                    len = lps[len-1];
                    // Also, note that we do not increment i here
                } else { // if (len == 0) 
                    lps[i] = len;
                    i++;
                }
            }
        }
        
        return lps;
         
    }
	
    public static void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
         
        // create lps[] that will hold the longest prefix suffix
        // values for pattern
        
        int j = 0;  // index for pat[]
         
        // Preprocess the pattern (calculate lps[] array)
        int lps[] = computeLPSArray(pat,M);
         
        int i = 0;  // index for txt[]
        while(i < N)
        {
            if(pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if(j == M)
            {
                System.out.println("Found pattern at index " + (i-j));
                j = lps[j-1];
            }
             
            // mismatch after j matches
            else if(i < N && pat.charAt(j) != txt.charAt(i))
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if(j != 0) {
                    j = lps[j-1];
                } else {
                    i = i+1;
                }
 
            }
        }
    }
	
	

}
