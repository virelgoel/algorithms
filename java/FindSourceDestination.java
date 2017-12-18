/*
 * Given a list of to and from cities, find the starting city and
 * print the itinerary.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSourceDestination {
	public static void getSourceLocation(List<List<String>> list) {
		Map<String, Boolean> destinations = new HashMap<>();
		Map<String, String> map = new HashMap<>();
		String start = null;
		
		for (List<String> set : list) {
			map.put((String) set.get(0), (String) set.get(1));
			destinations.put((String) set.get(1), true);
		}
		
		for (List<String> set : list) {
			if (!destinations.containsKey(set.get(0))) {
				start = (String) set.get(0);
				break;
			}
		}
		
		System.out.println("Starting point: " + start);
		
		String dest = start;
		while (map.containsKey(dest)) {
			System.out.print (dest + " ");
			dest = map.get(dest);
			destinations.remove(dest);
		}
		
		System.out.println(dest);
	}
	public static void main(String[] args) {
		List<List<String>> locations = new ArrayList<>();
		
		locations.add(new ArrayList<>(Arrays.asList("LAX", "SFO")));
		locations.add(new ArrayList<>(Arrays.asList("DCA", "LAX")));
		locations.add(new ArrayList<>(Arrays.asList("SEA", "DCA")));
		locations.add(new ArrayList<>(Arrays.asList("SFO", "JFK")));
		locations.add(new ArrayList<>(Arrays.asList("JFK", "DAL")));

		getSourceLocation(locations);
	}

}
