import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        // 1. Queue에 집어넣기.
        for(int i = 0; i < progresses.length; i++){
            q.add(i);
        }
        
        int day = 0;
        int count = 0;
        
        while(!q.isEmpty()){
            int index = q.poll();
            int expiration = (int) Math.ceil((double)(100 - progresses[index]) / speeds[index]);
            
            if(expiration > day){
                if(day != 0){ // 첫 완성은 배포할 수 없다.
                    answer.add(count);
                    //day = expiration;
                    count = 0;
                }
                day = expiration;
            }
            count++;
        }
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
