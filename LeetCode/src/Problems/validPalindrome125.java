package Problems;

public class validPalindrome125 {
	public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if(s.length() == 0){
            return true;
        } else{
            int i =0;
            
            while( i < s.length()/2){
                char c1 = s.charAt(i);
                char c2 = s.charAt(s.length()- 1 - i);
                if(!valid(c1) || !valid(c2)){
                  continue;
                }
                i++;
            }
        }
        
        return true;
        
    }
    
    public static boolean valid(char c) {
        if((c >= 'a' && c <= 'z')){
            return true;
        } else {
            return false;
        }
        
    }
    
    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
           return true;
       }
       int head = 0, tail = s.length() - 1;
       char cHead, cTail;
       while(head <= tail) {
           cHead = s.charAt(head);
           cTail = s.charAt(tail);
           if (!Character.isLetterOrDigit(cHead)) {
               head++;
           } else if(!Character.isLetterOrDigit(cTail)) {
               tail--;
           } else {
               if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                   return false;
               }
               head++;
               tail--;
           }
       }

       return true;
       
   }

}
