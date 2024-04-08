import java.util.*;

class Solution {
    public int solution(String s) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        map.put("zero", 0);
	     map.put("one", 1);
	        map.put("two", 2);
	        map.put("three", 3);
	        map.put("four", 4);
	        map.put("five", 5);
	        map.put("six", 6);
	        map.put("seven", 7);
	        map.put("eight", 8);
	        map.put("nine", 9);
        
        for(String num : map.keySet()) {
            
            if(s.contains(num))
                s = s.replace(num, map.get(num).toString());
        }
        
        int answer = Integer.parseInt(s);
        
        return answer;
    }
}
