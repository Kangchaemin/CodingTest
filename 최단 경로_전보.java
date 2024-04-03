import java.util.*;
import java.io.*;

public class 최단경로_전보 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		int d[] = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
		}
		
		Arrays.fill(d, (int)1e9);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.get(x).add(new Node(y, z));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(C, 0));
		d[C] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nodeNum = node.num;
			int nodeDistance = node.distance;
			
			// 현재 노드가 이미 처리된 적이 있는 노드라면 무시
			if(d[nodeNum] < nodeDistance)
				continue;
			
			for(int i = 0; i < list.get(nodeNum).size(); i++) {
				Node getNode = list.get(nodeNum).get(i);
				int cost = d[nodeNum] + getNode.distance;
				
				if(cost < d[getNode.num]) {
					d[getNode.num] = cost;
					pq.add(new Node(getNode.num, cost));
				}
			}
		}
		
		int count = 0;
		int maxDistance = 0;
		for(int i = 1; i <= N; i++) {
			if(d[i] != (int)1e9) {
				count += 1;
				maxDistance = Math.max(maxDistance, d[i]);
			}
		}
		
		System.out.println((count - 1) + " " + maxDistance);

	}
	
	public static class Node implements Comparable<Node>{
		int num;
		int distance;
		
		public Node(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.distance, other.distance);
		}
	}
}
