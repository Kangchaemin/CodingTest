import java.util.*; 

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int loop = 0;
        int totalCount = 0;
        
        while(!s.equals("1")){
            //int count = (int)s.chars().filter(c -> c == '0').count();
            int zeroCount = 0;
            for(char c : s.toCharArray()){
                if(c == '0'){
                    zeroCount++;
                }
            }
            
            totalCount += zeroCount;
            
            //int afterLength = s.replaceAll("0", "").length();
            int afterLength = s.length() - zeroCount;
            
            s = Integer.toString(afterLength, 2);
            loop += 1;
        }
        
        answer[0] = loop;
        answer[1] = totalCount;
        
        return answer;
    }
}
