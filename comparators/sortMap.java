package Oct29;
import java.util.*;
public class SortMapKey {

	public static void main(String[] args) {
		
		// sort map key
		
		Map<String, String> map = new TreeMap<>(
			new Comparator<String>() {
				public int compare(String o1, String o2) {
					
					return Integer.parseInt(o2) - Integer.parseInt(o1); 
				}
			});
		map.put("78","778");
		map.put("77","79");
		map.put("79","2");
		map.put("80","2");
		map.put("76","2");
		System.out.println("sort key: ");
		for(String s : map.keySet()) {
			System.out.println(s);
		}
		
		// sort map value
		
		Map<String, String> map1 = new HashMap<>();
		map1.put("78","778");
		map1.put("77","77");
		map1.put("79","79");
		map1.put("80","80");
		map1.put("76","76");
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map1.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, String>>(){
		
		public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {

			return Integer.parseInt(o2.getValue()) - Integer.parseInt(o1.getValue());
			}
		});
		
		System.out.println("sort value: ");
		
        for(Map.Entry<String, String> mapping : list){ 
            System.out.println(mapping.getKey() + " : " + mapping.getValue()); 
        }
        
			
		
		
	}
	
}