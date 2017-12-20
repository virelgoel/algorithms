package sort;

/*
 * Merge sort algorithm
 * Time complexity:
 * Average case, Worst case, Best case - O(n log(n))
 */
public class Mergesort {
	private int[] arr;
	
	public Mergesort(int[] a){
		this.arr = a;
		mergeSort(arr);
		printArray(arr);
	}
	
	private void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	private void mergeSort(int[]a) {
		int len = a.length;
		//Base case, array of 1 element is always sorted
		if (len == 1) {
			return;
		}
		
		int mid = len / 2;               //Find the middle index to start splitting at
		int[] left = new int[mid];       //Create the left array
		int[] right = new int[len-mid];  //Create the right array
		
		//Populate the left array - Go from first to mid -1
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
			
		//Populate the right array - Go from mid to len - 1
		for (int j = mid; j < len; j++) {
			right[j-mid] = a[j];
		}
			
		//Recursively call the mergeSort method to work on the left sub-set
		mergeSort(left);
		//Recursively call the mergeSort method to work on the right sub-set
		mergeSort(right);
		//Merge the left and right sub-sets back to the original array
		merge(left, right, a);
	}
	
	private void merge(int[] left, int[] right, int[] a) {
		int leftLen = left.length;
		int rightLen = right.length;
		int i = 0, j = 0, k = 0;  //i for left index, j for right index, k for merged array index
		
		//as long as there are elements in both left and right
		while (i < leftLen && j < rightLen) {
			//if element in left is smaller, add to merged list and increment counters
			if (left[i] <= right[j]) {
				a[k] = left[i];
				i++;
				k++;
			}
			//Otherwise, add element from right to merged list and increment counters
			else {
				a[k] = right[j];
				j++;
				k++;				
			}
		}
		
		//If there are any remaining elements in left, add them to merged list
		while (i < leftLen) {
			a[k] = left[i];
			i++;
			k++;
		}
		
		//If there are any remaining elements in right, add them to merged list
		while (j < rightLen) {
			a[k] = right[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int[]x = new int[]{7,2,1,6,9,8,5,3,4};

		Mergesort ms = new Mergesort(x);
	}
}
