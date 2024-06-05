import java.util.*;

class Solution {
    ArrayList<Long> listX = new ArrayList<>();
    ArrayList<Long> listY = new ArrayList<>();
    
    public String[] solution(int[][] line) {
        for(int i = 0; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                checkLine(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
            }
        }
        
        long minX = Collections.min(listX);
        long maxX = Collections.max(listX);
        long minY = Collections.min(listY);
        long maxY = Collections.max(listY);
        
        int n = (int)Math.abs(minX - maxX) + 1;
        int m = (int)Math.abs(minY - maxY) + 1;
        
        String[][] map = new String[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(map[i], ".");
        
        for(int i = 0; i < listX.size(); i++){
            int locateX = (int) Math.abs(minX - listX.get(i));
            //int locateY = (int) Math.abs(maxY - listY.get(i));
            int locateY = (int) Math.abs(listY.get(i) - maxY);
            
            map[locateY][locateX] = "*";
        }
        
        String[] answer = new String[map.length];
        for(int i = 0; i < map.length; i++){
            answer[i] = String.join("", map[i]);
        }
        return answer;
    }
    
    public void checkLine(long a, long b, long e, int c, int d, int f){
        
        if( (a * d - b * c) == 0 )
            return;
        double pointX = (double) (b * f - e * d) / (a * d - b * c);
        double pointY = (double) (e * c - a * f) / (a * d - b * c);
        
        if( (pointX % 1 == 0) && (pointY % 1 == 0) ){
            listX.add((long)pointX);
            listY.add((long)pointY);
        }
    }
}
