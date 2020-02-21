package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16234_인구이동 {
	static int N, L, R;
	static int map[][], check[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	static boolean range(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > N - 1)
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

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	static Queue<Point> q = new LinkedList<>();

	public static void bfs(int x, int y) {
		q.add(new Point(x, y));
		check[x][y] = 1;

		while (!q.isEmpty()) {
			int qx = q.peek().x;
			int qy = q.peek().y;
			q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (!range(nx, ny))
					continue;
				if (check[nx][ny] == 0) {
					if (Math.abs(map[x][y] - map[nx][ny]) >= L && Math.abs(map[x][y] - map[nx][ny]) <= R) {
						q.add(new Point(nx, ny));
						check[nx][ny] = 1;
					}
				}
				System.out.println();
				for (int i1 = 0; i1 < N; i1++) {
					System.out.println(Arrays.toString(check[i1]));
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		check = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] == 0)
					bfs(i, j);
				// System.out.print(check[i][j] + " ");
			}
			// System.out.println();
		}

		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(check[i]));
		}
	}
}
