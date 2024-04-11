import java.util.*;

class Solution {
    ArrayList<String> list = new ArrayList<>();
    char[] arr = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        mkString("");
        
        return list.indexOf(word);
    }
    
    public void mkString(String word){
        list.add(word);
        
        if(word.length() == 5){
            return;
        }
        
        for(char letter : arr){
            mkString(word + letter);
        }
        
        return;
    }
}
