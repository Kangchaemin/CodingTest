import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        ArrayList<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++) {
            if(!list.contains(my_string.charAt(i))){
                list.add(my_string.charAt(i));
                sb.append(my_string.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
