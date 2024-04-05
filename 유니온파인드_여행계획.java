import java.util.*;
import java.io.*;

public class UnionFind_여행계획 {
	
	static int parent[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					unionParent(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int checkParent = findParent(Integer.parseInt(st.nextToken()));
		boolean flag = true;
		for(int i = 1; i < M; i++) {
			if(checkParent != findParent(Integer.parseInt(st.nextToken()))) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	public static void unionParent(int a, int b) {
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
		}
		return parent[x] = findParent(parent[x]);
	}

}
