import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        //가장 중요한 부분
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        
        Arrays.sort(rocks);
        
        long start = 1;
        long end = (long) (distance + 1);
        
        while(start < end){
            long mid = (start + end) / 2;
            long current = 0;
            int count = 0;
            
            for(int i = 0; i < rocks.length; i++){
                if(rocks[i] - current >= mid){
                    current = rocks[i];
                    count++;
                }
            }
            
            if(count >= (rocks.length - n)){
                start = mid + 1;
            } else{
                end = mid;
            }
        }
        
        return (int)end - 1;
    }
}
