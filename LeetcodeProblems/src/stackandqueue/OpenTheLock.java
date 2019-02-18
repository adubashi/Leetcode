package stackandqueue;

import java.util.HashSet;

import java.util.Set;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.*;

/*
 * You have a lock in front of you with 4 circular wheels.
 *  Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000',
 a string representing the state of the 4 wheels.

You are given a list of deadends dead ends,
 meaning if the lock displays any of these codes,
  the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock,
return the minimum total number of turns required to open the lock,
 or -1 if it is impossible.
 */

public class OpenTheLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] array = {"0201","0101","0102","1212","2002"};
		String target = "0202";
		
		int res = openLock(array, target);
		
		char b = incrementChar('0');
		System.out.println(b);
		
		System.out.println(res);

	}
	
	/*
	 * USE BFS solution to go iterate over each step.
	 * 
	 * We start out at the point 0000.
	 * 
	 * For each starting point, we iterate through the string and 
	 * 
	 * 1. increment a character.
	 * If we've already visited that string or it's in the deadends array, then do nothing
	 * If it's not then add it to the set and add it to the queue.
	 * 
	 * 1. decrement a character.
	 * If we've already visited that string or it's in the deadends array, then do nothing
	 * If it's not then add it to the set and add it to the queue.
	 * 
	 * So we iterate through the string(4 times, the length) and then add both the decremented/incremented string to the queue 
	 * If we get through one iteration of that, then that's one step(so increment the step count)
	 */
	public static int openLock(String[] deadends, String target) {
		
		
		
		Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(target) || deadSet.contains("0000")) {
            return -1;
        }
        
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
        		int size = queue.size();
        		
        		for (int i = 0; i < size; i++) {
        			String curr = queue.poll();
                if (curr.equals(target)) {
                        return step;
                }
                for (int pos = 0; pos < 4; pos++) {
                	 	//use the pos to iterate each step
                		char[] charArray = curr.toCharArray();
                		//Change character at position
                		//Go forward
                		charArray[pos] = incrementChar(charArray[pos]);
                		String nextString = new String(charArray);
                		if (!visited.contains(nextString) && !deadSet.contains(nextString)) {
                            queue.offer(nextString);
                            visited.add(nextString);
                     }
                		//Go backward
                		charArray[pos] = decrementChar(charArray[pos]);
                		String backString = new String(charArray);
                		if (!visited.contains(backString) && !deadSet.contains(backString)) {
                            queue.offer(backString);
                            visited.add(backString);
                     }
                		
                }
        		}
        		step++;
        }
		return step;
    }
	
	private static char incrementChar(char c) {
		 return (char)((c + 11 - '0') % 10 + '0');
	}
	
	private static char decrementChar(char c) {
		 return (char)((c + 8 - '0') % 10 + '0');
	}

}
