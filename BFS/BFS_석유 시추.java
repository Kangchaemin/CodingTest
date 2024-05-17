import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;

        boolean visit[][] = new boolean[n][m];
        int[] moveX = {1, -1, 0, 0};
        int[] moveY = {0, 0, 1, -1};

        Queue<Integer> qX = new LinkedList<>();
        Queue<Integer> qY = new LinkedList<>();

        Map<Integer, Integer> map = new HashMap<>();
        int landNum = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if( land[i][j] == 0 || visit[i][j] )
                    continue;
                
                ArrayList<Integer> listX = new ArrayList<>();
                ArrayList<Integer> listY = new ArrayList<>();

                qX.add(i);
                qY.add(j);
                visit[i][j] = true;
                //listX.add(i);
                //listY.add(j);
                land[i][j] = landNum;
                int count = 1;

                while(!qX.isEmpty()){
                    int X = qX.poll();
                    int Y = qY.poll();

                    for(int mx = 0; mx < moveX.length; mx++){
                        int goX = X + moveX[mx];
                        int goY = Y + moveY[mx];

                        if(goX < 0 || goY < 0 || goX >= n || goY >= m)
                            continue;

                        if(land[goX][goY] == 0 || visit[goX][goY])
                            continue;

                        qX.add(goX);
                        qY.add(goY);
                        visit[goX][goY] = true;
                        //listX.add(goX);
                        //listY.add(goY);
                        land[goX][goY] = landNum;
                        count++;
                    }
                }

                map.put(landNum, count);
                // for(int l = 0; l < listX.size(); l++){
                //     //land[listX.get(l)][listY.get(l)] = count;
                //     land[listX.get(l)][listY.get(l)] = landNum;
                // }
                landNum++;
            }
        }

        for(int j = 0; j < m; j++){
            Set<Integer> oilSet = new HashSet<>();
            int oilSum = 0;
            for(int i = 0; i < n; i++){
                int oil = land[i][j];
                if(oil != 0 && !oilSet.contains(oil)) {
                    oilSet.add(oil);
                    //oilSum += oil;
                    oilSum += map.get(oil);
                }
            }
            answer = Math.max(answer, oilSum);
        }
        return answer;
    }
}
