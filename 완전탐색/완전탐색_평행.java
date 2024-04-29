import java.util.*;

class Solution {
    boolean[] visit = new boolean[4];
    List<int[]> listComb = new ArrayList<>();
    
    public int solution(int[][] dots) {
        dfs(0, 0, new int[2], dots);
        
        for(int[] A : listComb){
            int[] B = new int[2];
            boolean[] check = new boolean[4];
            
            for(int choice : A){
                check[choice] = true;
            }
            
            int index = 0;
            for(int i = 0; i < 4; i++){
                if(!check[i]){
                    B[index] = i;
                    index++;
                }   
            }
            
            double slope1 = getSlope(dots[A[0]][0], dots[A[0]][1], dots[A[1]][0], dots[A[1]][1]);
			double slope2 = getSlope(dots[B[0]][0], dots[B[0]][1], dots[B[1]][0], dots[B[1]][1]);
            
            if(slope1 == slope2){
                return 1;
            }
        }
        return 0;
    }
    
    public double getSlope(int x1, int y1, int x2, int y2){
        return (double) (y2 - y1) / (x2 - x1);
    }
    
    public void dfs(int depth, int start, int[] arr, int[][] dots){
        if(depth == 2){
            listComb.add(arr.clone());
            return;
        }
        
        for(int i = 0; i < dots.length; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i;
                dfs(depth+1, i+1, arr, dots);
                //visit[i] = false;
            }
        }
    }
}
