import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        
        // 1. Queue를 bridge_length만큼 채워준다.
        for(int i = 0; i < bridge_length; i++){
            q.add(0);
        }
        
        // 2.
        int truckIndex = 0;
        int time = 0;
        int bridgeW = 0;
        while(truckIndex < truck_weights.length){
            bridgeW -= q.poll();
            int nowTruckW = truck_weights[truckIndex];
            
            if(bridgeW + nowTruckW <= weight){
                bridgeW += nowTruckW;
                q.add(nowTruckW);
                truckIndex++;
            } else{
                q.add(0);
            }
            
            time++;
        }
        
        while(bridgeW > 0){
            bridgeW -= q.poll();
            time++;
        }
        
        return time;
    }
}
