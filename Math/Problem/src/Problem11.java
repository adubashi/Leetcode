
public class Problem11 {

	
	public static void main(String args[]){
		
		int filling = 0;
		int bucket1 = 7;
		int bucket2 = 11;
		
		for(filling = 0; filling < 50; filling++){
			int gal1 = bucket1 * filling;
			int gal2 = bucket2 * filling;
			System.out.println("Fill " + filling + ". Multiple of 7: " + gal1 + " Multiple of 11: " + gal2);
			int difference = gal2 - gal1;
			//System.out.println("Difference: " + difference);
		}
	}
}
