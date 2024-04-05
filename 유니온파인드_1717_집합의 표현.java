import java.util.*;
import java.io.*;

public class Main {

	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(check == 0) { // 합집합
				union(a, b);
				
			} else { // a와 b가 같은 집합에 있는지 확인
				if(findParent(a) == findParent(b)) {
					sb.append("YES" + "\n");
				} else {
					sb.append("NO" + "\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}
	
	public static int findParent(int x) {
		if(parent[x] == x) {
			return x;
		} else {
			return parent[x] = findParent(parent[x]);
		}
	}

}
