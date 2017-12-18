import java.util.HashMap;
import java.util.Map;

public class CompareStringAnagrams {
	/*
	 * Compare if 2 strings are anagrams
	 */
	public static boolean areAnagrams(char[] str1, char[] str2) {
		boolean status = false;
		int i;
		
		if (str1.length != str2.length) {
			status = false;
		}
		else {
			Map<Character, Integer> strMap = new HashMap<>();
			
			for (i = 0; i < str1.length; i++) {
				if (strMap.containsKey(str1[i])) {
					strMap.put(str1[i], (strMap.get(str1[i]) + 1));
				}
				else {
					strMap.put(str1[i], 1);
				}
			}
			
			
			for (i = 0; i < str2.length; i++) {
				if (strMap.containsKey(str2[i])) {
					strMap.put(str2[i], (strMap.get(str2[i]) - 1));
					
					if (strMap.get(str2[i]) == 0)
						strMap.remove(str2[i]);
				}
				else {
					status = false;
					break;
				}
			}
			
			if (strMap.isEmpty())
				status = true;
		}
		
		return status;
	}
	
	public static void main(String[] args) {
		System.out.println(areAnagrams("buckethead".toCharArray(), "deathcubek".toCharArray()));
	}
}