import java.util.*;
import java.io.*;

public class 최단거리_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		int d[] = new int[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
			d[i] = (int)1e9;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list.get(A).add(new Node(B, 1));
			list.get(B).add(new Node(A, 1));
		}
		
		d[1] = 0;
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(d[node.num] < node.dis) continue;
			
			for(int i = 0; i < list.get(node.num).size(); i++) {
				int nextNum = list.get(node.num).get(i).num;
				int cost = d[node.num] + list.get(node.num).get(i).dis;
				if(cost < d[nextNum]) {
					d[nextNum] = cost;
					pq.add(new Node(nextNum, cost));
				}
			}
		}
		
		int minIndex = 0;
		int maxDistance = 0;
		int countSame = 0;
		
		for(int i = 2; i <= N; i++) {
			if(d[i] != (int)1e9 && (maxDistance) < d[i]) {
				maxDistance = d[i];
				minIndex = i;
				countSame = 1;
			} else if(maxDistance == d[i]) {
				countSame += 1;
			}
		}
		System.out.println(minIndex + " " + maxDistance + " " + countSame);

	}
	
	public static class Node implements Comparable<Node> {
		int num;
		int dis;
		
		public Node(int num, int dis) {
			this.num = num;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.dis, other.dis);
		}
	}

}
