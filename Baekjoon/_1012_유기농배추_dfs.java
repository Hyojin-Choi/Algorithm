import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1012_¿Ø±‚≥ÛπË√ﬂ_dfs {
	static int T, N, M, K, cnt;
	static int map[][], check[][];
	static int dx[] = { 0, 0, -1, 1 }, dy[] = { 1, -1, 0, 0 };

	static boolean range(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > M - 1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			check = new int[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && check[i][j] == 0) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(cnt);
			cnt=0;
		} // t

	}
	static public void dfs(int x,int y) {
		check[x][y] = 1;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(range(nx,ny) && check[nx][ny] == 0 && map[nx][ny] == 1) {
				dfs(nx,ny);
			}
		}
	}
}
