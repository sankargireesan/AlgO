package algo;

public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = {2,50,52,75,99};
		
		StringBuffer sb = new StringBuffer();
		if(arr[0]!=0) {
			if(arr[0]==1) {
				sb.append("0,");
			}else {
				sb.append("0-").append(arr[0]-1).append(",");
			}
		}
		int i;
		for( i=1;i<arr.length;i++) {
			if(arr[i-1]+1 == arr[i])
				continue;
			else if(arr[i-1]+2 == arr[i])
				sb.append(arr[i]-1).append(",");
			else {
				sb.append(arr[i-1]+1).append("-").append(arr[i]-1).append(",");
			}
		}
		
		if(arr[i-1]!=99) {
			sb.append(arr[i-1]+1).append("-").append(99).append(",");
		}
		
		System.out.println(sb.substring(0,sb.length()-1).toString());
	}
}
