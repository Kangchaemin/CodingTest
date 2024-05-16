import java.util.*;

class Solution {
    boolean map[][];
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        map = new boolean[n+1][n+1];
        for(int i = 0; i < results.length; i++){
            map[results[i][0]][results[i][1]] = true;
        }
        
        
        for(int i = 1; i <= n; i++){
            int wins = countWin(i, n, new boolean[n+1]) - 1;
            int loses = countLose(i, n, new boolean[n+1]) - 1;
            
            if(wins + loses + 1 == n){
                answer++;
            }
        }
        return answer;
    }
    
    public int countWin(int u, int n, boolean[] visit){
        int count = 1;
        
        for(int v = 1; v <= n; v++){
            if(visit[v] || !map[u][v]) continue;
            visit[v] = true;
            count += countWin(v, n, visit);
        }
        
        return count;
    }
    
    public int countLose(int v, int n, boolean[] visit){
        int count = 1;
        
        for(int u = 1; u <= n; u++){
            if(visit[u] || !map[u][v]) continue;
            visit[u] = true;
            count += countLose(u, n, visit);
        }
        
        return count;
    }
}
