package Problems;

import java.util.*;

public class bullsAndCows299 {

	public static void main(String args[]) {
		
		String secret = "1807";
		String guess = "7810";
		
		System.out.println(getHint(secret,guess));

	}

	public static String getHint(String secret, String guess) {

		int bulls = 0;
		int cows = 0;
		// Count bulls
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < secret.length(); i++){
			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				// Update the map
				char c =secret.charAt(i);
                if (map.containsKey(c)) {
                    int freq = map.get(c);
                    freq++;
                    map.put(c, freq);
                } else {
                    map.put(c, 1);
                }
			}
		}
		// Count cows
		for (int i = 0; i < secret.length();i++) {
			char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s != g) {
                if (map.containsKey(g)) {
                    cows++;
                    // update the map
                    if (map.get(g) == 1) {
                        map.remove(g);
                    } else {
                        int freq = map.get(g);
                        freq--;
                        map.put(g, freq);
                    }
                }
            }
		}


		return bulls + "A" + cows + "B";

	}

}
