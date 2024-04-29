class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int step = 1; step < s.length() / 2 + 1; step++) {
            
            String prev = s.substring(0, step);
            String answer_prev = "";
            int count = 1;
            
            for(int j = step; j < s.length(); j += step) {
                
                String next = "";
                
                for(int k = j; k < j + step; k++) {
                    if(k < s.length())
                        next += s.charAt(k);
                }
                
                if(prev.equals(next)){
                    count++;
                }
                
                else {
                    
                    answer_prev += (count >= 2) ? count + prev : prev;
                    
                    count = 1;
                    
                    prev = next;
                }
            }
            
            answer_prev += (count >= 2) ? count + prev : prev;
            
            answer = Math.min(answer, answer_prev.length());
        }
        return answer;
    }
}
