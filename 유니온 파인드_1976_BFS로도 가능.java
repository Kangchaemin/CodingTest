import java.util.*;
import java.io.*;

public class Main {

	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int checkParent = findParent(Integer.parseInt(st.nextToken()));
		for(int i = 1; i < M; i++) {
			if(checkParent != findParent(Integer.parseInt(st.nextToken()))) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
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
