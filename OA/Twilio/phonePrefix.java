package twilio;
import java.util.*;

/**
 * We can use trie too.
 * @author tianshiwang
 *
 */
public class Prefix {
	/**
	 * let length of prefix list to be m, phonenum list to be n
	 * Set prefix O(m)
	 * for phonenum list: O(m) length of phone num O(k) k<=15; 
	 * Search in hashset: O(k) 
	 * Total: O(m*k*k) + O(n) -> O(mkk) -> O(N)
	 * @param prefix
	 * @param phonenum
	 * @return
	 */
	public List<String> getLongestPrefix(List<String> prefix, List<String> phonenum) {
		List<String> result = new ArrayList<>();
		Set<String> prefixMap = new HashSet<>();
		for (String pre : prefix) {
			prefixMap.add(pre);
		}
		search:
		for (String phone : phonenum) {
			int length = phone.length();
			while(length > 0) {
				String s = phone.substring(0,length);
				if(prefixMap.contains(s)) {
					result.add(s);
					continue search;
				}
				length--;
			}
			result.add("");
		}
		return result;
	}
	
	public static void main(String[] args) {

		List<String> prefixList = new ArrayList<>();
		prefixList.add("+1415123");
		prefixList.add("+1415000");
		prefixList.add("+1412");
		prefixList.add("+1510");
		prefixList.add("+1");
		prefixList.add("+44");
		
		List<String> phonenum = new ArrayList<>();
		phonenum.add("+14151234567");
		phonenum.add("+9990");
		phonenum.add("+1412");
		phonenum.add("+14151224983");
		phonenum.add("+14151224983");
		
		Prefix pre = new Prefix();
		List<String> res = pre.getLongestPrefix(prefixList, phonenum);
		
		for (String s: res) {
			System.out.print("Str: " + s + "\n");
		}
		System.out.print("len: " + res.size() + "\n");
	}
	
	
}
