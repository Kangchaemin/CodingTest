import java.util.*;
class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for(int i = 0; i < costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            
            if(findParent(a) != findParent(b)){
                union(a, b);
                answer += cost;
            }
        }
        return answer;
    }
    
    public int findParent(int x){
        if(x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }
    
    public void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        
        if(a < b){
            parent[b] = a;
        } else{
            parent[a] = b;
        }
    }
}
