import java.util.*;
import java.io.*;

public class Main {
	
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		visit = new boolean[N+1];
		ArrayList<Integer> plans = new ArrayList<>();
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					list.get(i).add(j);
				}
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			plans.add(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(plans.get(0));
		visit[plans.get(0)] = true;
		
		while(!q.isEmpty()) {
			
			int X = q.poll();
			
			for(int i = 0; i < list.get(X).size(); i++) {
				int nextNode = list.get(X).get(i);
				
				if(!visit[nextNode]) {
					visit[nextNode] = true;
					q.add(nextNode);
				}
			}
		}
		
		for(int i = 1; i < plans.size(); i++) {
			if(!visit[plans.get(i)]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
