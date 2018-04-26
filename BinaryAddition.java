package algo;

public class BinaryAddition {

	public static void main(String[] args) {
		String a = "0000";
		String b = "10000";
		
		StringBuilder sb = new StringBuilder();
		
		int la = a.length()-1;
		int lb = b.length()-1;
		
		int max = Math.max(la, lb);
		
		int carry =0;
		for(int i =0;i<=max;i++) {
			int m = getBit(a,la-i);
			int n = getBit(b,lb-i);
			sb.insert(0, (m+n+carry)%2);
			carry = (m+n+carry)/2;
		}
		
		if(carry !=0) {
			sb.insert(0, 1);
		}
		System.out.println(sb);
	}
	
	public static int getBit(String a, int i) {
		
		if(i<0||a.charAt(i)=='0') {
			return 0;
		}
		return 1;
	}
}
