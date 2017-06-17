package ProblemsBasedOnDataStructures.BitManipulation.hammingDistance461;

public class HammingDistance {
	
	//Accepted
	//Basically just calculates the hamming weight of the XOR between integers
	//There are more efficient ways to calculate hamming weight, as this requires
	// converting this binary string 
	public static int hammingDistance(int a, int b){
		int xor = a^b;
		System.out.println(xor);
		//Calculates hamming weight
		String bString = Integer.toBinaryString(xor);
		int differenceCount = 0;
		for(int i = 0; i < bString.length(); i++){
			if(bString.charAt(i) == '1'){
				differenceCount++;
			}
		}
		return differenceCount;
	}
	
	public static int getBit(int n, int i){
	    if((n & (1 << i)) != 0){
	    	return 1;
	    } else {
	    	return 0;
	    }
	}
	
	public static int hammingWeight(int a){
		int count = 0;
		//32 bits in the integer
		for(int i = 1; i < 33; i++){
			if(getBit(a,i) == 1){
			   count++;
			}
		}
		return count;
	}
	
	public static int hammingDistance2(int a, int b){
		int xor = a^b;
		System.out.println(xor);
		return hammingWeight(xor);
	}
	
	public static int hammingDistance3(int a, int b){
		int count = 0;
		for(int i = 1; i < 33; i++){
			if(getBit(a,i) != getBit(b,i)){
				count++;
			}
		}
		return count;
	}

	
	
	
	
	public static void main(String args[]){
		System.out.println(hammingDistance3(1,4));
	}

}
