import java.util.*;
import java.io.*;

public class 플로이드워셜_1389 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = (int)1e9;
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		for(int k = 1; k <= n; k++) {
			for(int a = 1; a <= n; a++) {
				for(int b = 1; b <= n; b++) {
					map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int answer = 0;
		
		for(int i = 1; i <= n; i++) {
			int result = 0;
			for(int j = 1; j <= n; j++) {
				result += map[i][j];
			}
			if(min > result) {
				min = result;
				answer = i;
			}
		}
		System.out.println(answer);
	}
}
