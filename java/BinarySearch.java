/*
 * Binary search to find the index of an element in array
 * line 15: high = mid - 1 was added to find lowest index
 * in case of duplicates. If duplicates are not considered,
 * replace the statement with a break;
 */
public class BinarySearch {
	public static int binarySearch(int a[], int x) {
		int low = 0, high = a.length-1, result = -1;
		int mid;
			
		while (low <= high) {
			mid = (high + low) / 2;
			
			if (a[mid] == x) {
				result = mid;
				high = mid - 1;
			}
			else if (a[mid] > x) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
	
		return result;
	}
	
	public static void main(String[] args) {
		 int arr[] = {2, 3, 4, 4, 4, 5, 10, 40};
		 System.out.println(binarySearch(arr, 4));
	}
}
