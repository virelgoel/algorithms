
public class MaxSumSubArray {
	public static int maxSum(int[] a, int len) {
		int res = a[0];
		int sum = a[0];
		
		for (int i = 1; i <= len-1; i++) {
			//Compare the current number and it's sum with the current value of sum, assign
			//the larger value to sum
			sum = Math.max(a[i], sum + a[i]);
			//Assign the largest of the new sum and previous res value to res
			res = Math.max(res, sum);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{-2, -3, 4, -1, 2, 1, -5, -3};

		System.out.println(maxSum(a, a.length));

	}
}
