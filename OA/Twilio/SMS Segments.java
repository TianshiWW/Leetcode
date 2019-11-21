package twilio;
import java.util.*;

public class SMS {
	//leave space for "(1/5)" ,static maxLen to be 154
	static int MAXLEN = 154;
	
	/**
	 * Change message to several segements 
	 * @param message
	 * @return
	 */
	public List<String> segments(String message){
	    List<String> result = new ArrayList<>();
	    // if we can send it in just one result, return this string  
	    if (message.length() < 160) {
	        result.add(message);
	        return result;
	    }
	
	    // start pointer
	    int start = 0;
	    // end pointer, to leave space for "(1/5)" 
	    int end = start + MAXLEN;
	    
	    // start counting
	    while (end < message.length()) {
	    	// if the last char is a word, we have to find the last message which is not a word.
	        if (message.charAt(end) != ' ') {
	            while (end >= start && message.charAt(end) != ' ' && message.charAt(end + 1) != ' ') {
	            	end--;
	            }
	        }
	    
	        // if lastone is a space " ", result add the substring
	        result.add(message.substring(start, end + 1));
	        start = end + 1;
	        end = start + MAXLEN;
	    }
	    
	    // add the last string to the result 
	    result.add(message.substring(start, message.length()));
	    
	    // count how many message we have and add e.g "(1/4)"
	    for (int i = 0; i < result.size(); i++) {
	        result.set(i, result.get(i)+"(" + (i + 1) + "/" + (result.size()) + ")");
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		String s = "njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkasadasdasdadasdasdasdasdasdasdagjdsljgdslkjgdsfjnsssssssgds lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg";
		SMS sms = new SMS();
		List<String> res = sms.segments(s);
		for (String str : res) {
			System.out.println(str);
		}
	}
	
}