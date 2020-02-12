import java.io.*;
import java.util.*;

public class _2667_단지번호붙이기_dfs {
	static int N, cnt, max = Integer.MIN_VALUE;
	static int dx[] = { 0, 0, -1, 1 }, dy[] = { 1, -1, 0, 0 };
	static int map[][], check[][], arr[];

	static boolean range(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > N - 1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && check[i][j] == 0) {
					cnt++;
					dfs(i, j);
				}
			}
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] > max)
					max = check[i][j];
			}
		}
		arr = new int[max+1];

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int idx = 0;
				if(check[i][j] != 0) {
					idx = check[i][j];
					arr[idx]++;
				}
			}
		}
		Arrays.sort(arr);
		System.out.println(max);
		for(int i=0; i<=cnt; i++) {
			if(i==0) continue;
			System.out.println(arr[i]);
		}
	}

	public static void dfs(int x, int y) {
		check[x][y] = cnt;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (range(nx, ny) && map[nx][ny] == 1 && check[nx][ny] == 0) {
				dfs(nx, ny);
			}
		}
	}
}
