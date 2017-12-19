public class StringPermutations {
	public static void stringPermutations(char[]a, int start, int len) {
		char temp;

		if (start == len) {
			System.out.println(String.valueOf(a));
		}	
		else {
			for (int i = start; i < len; i++) {
				temp = a[start];
				a[start] = a[i];
				a[i] = temp;

				stringPermutations(a, start+1, len);

				temp = a[start];
				a[start] = a[i];
				a[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		String str = "abc";
		stringPermutations(str.toCharArray(), 0, str.length());
	}
}