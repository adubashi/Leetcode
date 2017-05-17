package Company1Search;

public class PowerOfThree326 {
	public static boolean isPowerOfThree(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

}
