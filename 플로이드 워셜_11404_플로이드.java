import java.util.*;
import java.io.*;

public class 플로이드워셜_11404 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
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
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = Math.min(c, map[a][b]);
		}
		
		for(int k = 1; k <= n; k++) {
			for(int a = 1; a <= n; a++) {
				for(int b = 1; b <= n; b++) {
					map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == (int)1e9) {
					map[i][j] = 0;
				}
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
