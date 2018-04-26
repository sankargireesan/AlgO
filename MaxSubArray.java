package algo;

public class MaxSubArray {
	
	public static int maxSumArray(int[] arr) {
		
		int max =Integer.MIN_VALUE;
		
		int[] s = new int[arr.length];
		for(int i=0 ;i<arr.length;i++)
			s[i] = arr[i];
		
		for(int i=1;i<arr.length;i++) {
			if(s[i] < s[i-1]+arr[i]) {
				s[i] = s[i-1]+arr[i];				
			}
		}
		
		for(int a : s)
			max = Math.max(max, a);
		
		
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {-2,-3,4,-1,-2,1,5,-3};
		
		System.out.println(maxSumArray(arr));
	}

}
