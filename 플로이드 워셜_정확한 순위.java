import java.util.*;
import java.io.*;

public class 플로이드워셜_정확한순위 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = (int)1e9;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A][B] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int a = 1; a <= N; a++) {
				for(int b = 1; b <= N; b++) {
					map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
				}
			}
		}
		
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			int count = 0;
			for(int j = 1; j <= N; j++) {
				if(map[i][j] != (int)1e9 || map[j][i] != (int)1e9 ) {
					count += 1;
				}
			}
			if(count == N) {
				answer += 1;
			}
		}
		System.out.println(answer);
	}

}
