import java.util.*;

class Solution {
    public int[][] solution(int n) {
        ArrayList<int[]> list = new ArrayList<>();
        hanoi(n, 1, 3, list);
        return list.toArray(new int[0][]);
    }
    
    public void hanoi(int n, int from, int to, ArrayList<int[]> list){
        if(n == 1){
            list.add(new int[]{from, to});
            return;
        }
        
        hanoi(n-1, from, 6-from-to, list);
        hanoi(1, from, to, list);
        hanoi(n-1, 6-from-to, to, list);
    }
}
