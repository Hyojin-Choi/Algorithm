package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17472_다리만들기2 {
	static int N, M;
	static int map[][];
	static int check[][];
	static int cnt = 0;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static boolean range(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > M - 1)
			return false;
		else
			return true;
	}

	static class Point {
		int x, y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Point> q = new LinkedList<>();

	static public void bfs(int x, int y) {
		map[x][y] = cnt;
		q.add(new Point(x, y));
		check[x][y] = 1;

		while (!q.isEmpty()) {
			int qx = q.peek().x;
			int qy = q.peek().y;
			q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];

				if (range(nx, ny) && check[nx][ny] == 0 && map[nx][ny] == 1) {
					map[nx][ny] = cnt;
					check[nx][ny] = 1;
					q.add(new Point(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && check[i][j] == 0) {
					cnt++;
					bfs(i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
