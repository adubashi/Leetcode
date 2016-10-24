
public class PrintMonth {
	
	
	public static void main(String args[]){
		printMonth(5,30);
	}

	
	public static void printMonth(int skipDays, int totalDays){
		
		for(int i = 1; i < skipDays + 1; i++){
			
			System.out.print(i + "\t");
		}

	}
}
