import java.util.*;
import java.util.stream.IntStream;

class Solution {
    int[][] rules = {{1, 2, 3, 4, 5}, 
                     { 2, 1, 2, 3, 2, 4, 2, 5}, 
                     {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    
    int[] count = new int[3];
    
    public int[] solution(int[] answers) {
        
        int max = 0;
        
        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < 3; j++){
                if(answers[i] == getCount(i, j)){
                    count[j] += 1;
                    
                    if(max < count[j]){
                        max = count[j];
                    }
                }
            }
        }
        
        final int maxCount = max;
        int[] answer = IntStream.range(0, 3)
                                .filter(i -> count[i] == maxCount)
                                .map(i -> i+1)
                                .toArray();
        return answer;
    }
    
    public int getCount(int problem, int person){
        int rule[] = rules[person];
        
        return rule[problem % rule.length];
    }
}
