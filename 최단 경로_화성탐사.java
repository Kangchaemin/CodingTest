import java.util.*;
import java.io.*;

public class 최단경로_화성탐사 {
	
	static int[] moveX = {1, -1, 0, 0};
	static int[] moveY = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			int d[][] = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(d[i], (int)1e9);
			}
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			pq.add(new Node(0, 0, map[0][0]));
			d[0][0] = map[0][0];
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				
				// 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if (d[node.x][node.y] < node.dis) continue;
				
				for(int mx = 0; mx < moveX.length; mx++) {
					int goX = node.x + moveX[mx];
					int goY = node.y + moveY[mx];
					
					if(goX < 0 || goY < 0 || goX >= N || goY >= N) {
						continue;
					}
					
					if(node.dis + map[goX][goY] < d[goX][goY]) {
						d[goX][goY] = node.dis + map[goX][goY];
						pq.add(new Node(goX, goY, d[goX][goY]));
					}
					
				}
			}
			//System.out.println(d[N-1][N-1]);
			sb.append(d[N-1][N-1] + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static class Node implements Comparable<Node> {
		int x;
		int y;
		int dis;
		
		public Node(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.dis, other.dis);
		}
	}

}


