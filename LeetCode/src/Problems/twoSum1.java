package Problems;
import java.util.*;

public class twoSum1 {

	public static void main(String[] args) {

	}
	// Iterate the array, if the map contains the key, then we return the result;
	// If it doesn't, then add (target-numbers[i]),i to the map
	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();
		int[] result = new int[2];
		for(int i = 0; i < numbers.length; i++){
			if(map.containsKey(numbers[i])){
				int index = map.get(numbers[i]);
				result[0] = index+1;
				result[1] = i + 1;
				break;
			} else {
				map.put(target - numbers[i], i);
			}
			
		}
		
		return result;
    }

}
