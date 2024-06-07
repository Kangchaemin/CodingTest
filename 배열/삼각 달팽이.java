import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        int map[][] = new int[n][n];
        
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        int x = 0;
        int y = 0;
        int d = 0;
        int v = 1;
        
        while(true){
            map[x][y] = v++;
            
            int goX = x + dx[d];
            int goY = y + dy[d];
            
            if(goX < 0 || goY < 0 || goX >= n || goY >= n || map[goX][goY] != 0){
                d = (d + 1) % 3;
                goX = x + dx[d];
                goY = y + dy[d];
                
                if(goX < 0 || goY < 0 || goX >= n || goY >= n || map[goX][goY] != 0){
                    break;
                }
            }
            x = goX;
            y = goY;
        }
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                //answer[index] = map[i][j];
                answerList.add(map[i][j]);
            }
        }
        
        /*
        int[] answer = new int[value - 1];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[index++] = triangles[i][j];
            }
        }
        */
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
