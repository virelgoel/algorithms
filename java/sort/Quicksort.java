package sort;

/*
 * Quick sort algorithm
 * Time complexity:
 * Average case, Best case - O(n log(n))
 * Worst case - O(n^2)
 */
public class Quicksort {
	private int[] arr;
	
	public Quicksort(int[] a){
		this.arr = a;
		quickSort(arr, 0, arr.length-1);
		printArray(arr);
	}
	private void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	private static void quickSort(int[] a, int start, int end) {
		//base case - only 1 element or invalid segment should not process
		//further. Process only as along as start is less than end
		if (start < end) {
			//Work on a segment of the array
			int pivotIndex = reArrange(a, start, end);
			quickSort(a, start, pivotIndex-1);
			quickSort(a, pivotIndex+1, end);			
		}
	}
	
	/*
	 * Choose a pivot element such that all the elements less than the pivot are
	 * to the left, all elements greater than the pivot are to the right.
	 * Pivot is placed between the left and right segments.
	 * Return the pivot index once done
	 */
	private static int reArrange(int[] a, int start, int end) {
		int pivot = a[end];
		int pivotIndex = start;	//start pivot index at the beginning
		
		for (int i = start; i < end; i++) {
			if (a[i] <= pivot) { //For decreasing order, change this to a[i] > pivot
				//swap a[i] and a[pivotIndex]
				int temp = a[i];
				a[i] = a[pivotIndex];
				a[pivotIndex] = temp;
				
				//increment the pivot index
				pivotIndex++;
			}
		}
		
		/*
		 * all elements less than pivot are to the left of pivotIndex,
		 * all elements greater than pivot are to the right of pivotIndex.
		 * Swap the pivot with the element at pivot index and return the pivot index
		 */
		int x = a[pivotIndex];
		a[pivotIndex] = a[end];
		a[end] = x;
		
		return pivotIndex;
	}

	public static void main(String[] args) {
		int[]x = new int[]{7,2,1,9,6,8,5,3,4};

		Quicksort qs = new Quicksort(x);
	}
}
