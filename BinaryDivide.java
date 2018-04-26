package algo;

public class BinaryDivide {

	private static int binaryDivide(int dividend, int divisor) {
		int current =1;
		int denom =divisor;
		
		while(denom <= dividend) {
			current = current<<1;
			denom <<=1;
		}
		
		denom>>=1;
		current>>=1;
		int ans = 0;
		
		while(current!=0) {
			
			if(dividend>=denom) {
				dividend -=denom;
				ans +=current;
			}
			
			current>>=1;
			denom>>=1;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(binaryDivide(20,4));
	}
}
