public class SortedArrayRotation {
	public static int rotatedArraySearch(int[]a, int len, int x) {
		int low = 0, high = len-1;
		int mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			
			//Found x at mid
			if (x == a[mid])
				return mid;
			//right half is sorted
			else if (a[mid] <= a[high]) {
				if (x > a[mid] && x <= a[high]) {
					low = mid + 1;	//search in right sorted half
				}
				else {
					high = mid - 1;	//search in left sorted half
				}
			}
			//left half is sorted
			else {
				if (a[low] <= x && x < a[mid])
					high = mid - 1; //search in left sorted half
				else
					low = mid + 1;  //search in right sorted half
			}
		}
		//could not find x
		return -1;
	}
	
	public static int rotationCount(int[]a) {
		int low = 0, high = a.length-1;
		
		while (low <= high) {
			//First element is the minimum, array wasn't rotated
			if (a[low] <= a[high])
				return low;
			
			int mid = (low + high) / 2;
			int next = (mid + 1) % a.length;
			int prev = (mid + a.length - 1) % a.length;

			//lowest element found at mid
			if (a[mid] <= a[next] && a[mid] <= a[prev])
				return mid;
			//if right half is sorted, mid will be less than high. Look in left half
			else if (a[mid] <= a[high])
				high = mid - 1;
			//otherwise, left half is sorted. Look in right half
			else
				low = mid + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {6,7,8,9,10,11,12,1,2,3,4,5};
		System.out.println(rotationCount(arr));
		System.out.println(rotatedArraySearch(arr, arr.length, 3));
	}
}