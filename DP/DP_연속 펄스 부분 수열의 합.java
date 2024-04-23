class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        boolean isPulse = true;
        
        long pulse1 = 0;
        long pulse2 = 0;
        
        for(int num : sequence){
            
            pulse1 += isPulse ? num : -num;
            pulse2 += isPulse ? -num : num;
            
            pulse1 = Math.max(0, pulse1);
            pulse2 = Math.max(0, pulse2);
            
            answer = Math.max(answer, Math.max(pulse1, pulse2));
            
            isPulse = !isPulse;
        }
        return answer;
    }
}
