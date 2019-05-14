package amazon;
import java.util.*;

public class RobotReturnToOrigin {
	public boolean judgeCircle(String moves) {
        
        List<Integer> pos = Arrays.asList(0,0);
        
        for(int i = 0; i < moves.length(); i++){
            
            if(moves.charAt(i) == 'U'){
                pos.set(1, pos.get(1) + 1);
            }
            if(moves.charAt(i) == 'D'){
                pos.set(1, pos.get(1) - 1);
            }
            if(moves.charAt(i) == 'L'){
                pos.set(0, pos.get(0) - 1);
            }
            if(moves.charAt(i) == 'R'){
                pos.set(0, pos.get(0) + 1);
            }
        }
        
        return pos.get(0) == 0 && pos.get(1) == 0;   
    }

}
