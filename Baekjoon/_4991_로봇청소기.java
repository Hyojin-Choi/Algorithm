package algorithm;

import java.io.*;
import java.util.*;

public class _4991_로봇청소기 {
	static int N, M, trash, sum;
	static char[][] map;
	static int check[][];
	static int sel[];
	static int ch[];
	static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };

	static boolean range(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > M - 1)
			return false;
		else
			return true;
	}

	static class Point {
		int x, y, cnt;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	static Queue<Point> q = new LinkedList<>();
	static int min = Integer.MAX_VALUE;
	static int minx, miny;

	public static void dfs(int idx) {

		if (idx == trash) {
			System.out.println(Arrays.toString(sel));
			bfs();
			return;
		}

		for (int i = 0; i < trash; i++) {
			if (ch[i] == 0) {
				ch[i] = 1;
				sel[idx] = i;
				dfs(idx + 1);
				ch[i] = 0;
			}
		}
	}

	public static void bfs() {
		int a = 0, b = 0;

		for (int t = 0; t < trash; t++) {
			if (t != 0)
				q.add(new Point(a, b, 0));

			int s = sel[t];

			while (!q.isEmpty()) {
				int qx = q.peek().x;
				int qy = q.peek().y;
				int qcnt = q.peek().cnt;
				q.poll();
				check[qx][qy] = 1;

				if (map[qx][qy] - '0' == s) {
					sum += qcnt;
					a = qx;
					b = qy;
					q.clear();
					return;
				}

				for (int i = 0; i < 4; i++) {
					int nx = qx + dx[i];
					int ny = qy + dy[i];

					if (!range(nx, ny))
						continue;
					if (check[nx][ny] == 1)
						continue;

					check[nx][ny] = 1;
					q.add(new Point(nx, ny, qcnt + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			check = new int[N][M];
			if (N == 0 && M == 0)
				return;
			trash = 0;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'o')
						q.add(new Point(i, j, 0));
					if (map[i][j] == '*') {
						map[i][j] = (char) trash;
						trash++;
					}
				}
			}

			sel = new int[trash];
			ch = new int[trash];
			// 순열 뽑으러 가보자
			dfs(0);

			System.out.println(sum);
		}
	}
}
