import java.util.*;
import java.io.*;

public class 플로이드워셜_11403 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int map[][] = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int a = 0; a < N; a++) {
				for(int b = 0; b < N; b++) {
					//map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
					if(map[a][k] == 1 && map[k][b] == 1) {
						map[a][b] = 1;
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
