import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visit[] = new boolean[n];
        int answer = 0;
        
        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < costs.length; i++){
            int v = costs[i][0];
            int w = costs[i][1];
            
            list.get(v).add(new Edge(w, costs[i][2]));
            list.get(w).add(new Edge(v, costs[i][2]));
        }
        
        pq.add(new Edge(0, 0));
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            
            if(visit[edge.node]) continue;
            
            visit[edge.node] = true;
            
            answer += edge.cost;
            for(Edge e : list.get(edge.node)){
                if(!visit[e.node]){
                    //System.out.println(edge.node + " " + e.node + " " + e.cost);
                    pq.add(new Edge(e.node, e.cost));
                }
            }
        }
        
        return answer;
    }
    
    public class Edge implements Comparable<Edge> {
        int node;
        int cost;
        
        public Edge(int node, int cost){
            this.node = node;
            this.cost = cost;            
        }
        
        @Override
        public int compareTo(Edge other){
            return Integer.compare(this.cost, other.cost);
        }
    }
}
