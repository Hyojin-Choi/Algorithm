package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2573_빙산 {
	static int N, M;
	static int map[][], check[][], ze[][];
	static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };
	static int cnt, zcnt, res;

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

	static public void zero(int x, int y) {
		zcnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (range(nx, ny) && map[nx][ny] == 0) {
				zcnt++;
			}
		}
		ze[x][y] = zcnt;
	}

	static Queue<Point> q = new LinkedList<>();

	static public void bfs(int x, int y) {
		check[x][y] = 1;
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			int qx = q.peek().x;
			int qy = q.peek().y;
			q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];

				if (range(nx, ny) && map[nx][ny] != 0 && check[nx][ny] == 0) {
					check[nx][ny] = 1;
					q.add(new Point(nx, ny));
				}
			}

		}
	}

	public static void dfs(int x, int y) {
		check[x][y] =1;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(range(nx,ny) && map[nx][ny] != 0 && check[nx][ny] == 0) {
				check[nx][ny] =1;
				dfs(nx,ny);
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
		ze = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			for(int i=0; i<N; i++) {
				Arrays.fill(check[i], 0);
			}
			cnt = 0;
			
			// 이거이거 뭐냐면
			// 그거 체크해야지 ,, 그 먼저 2덩어리 이상이면
			// 할 필요없으니깐 체크하자 !
			//System.out.println("aaa");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (check[i][j] == 0 && map[i][j] != 0) {
						cnt++;
						// 이거 dfs로 바꿔보즈아 !~~!! ! ! 
						//bfs(i, j);
						dfs(i,j);
					}
				}
			}

			// 만약 cnt ==0 이면 0출력하고 그만두지만
			if (cnt == 0) {
				System.out.println("0");
				return;
			}

			if (cnt >= 2) {
				// 최종값 출력
				System.out.println(res);
				return;
			}
			// 0이 아니라면 0의 개수를 빼주고 총 년수를 더해줘
			// 0의 개수 체크
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						zero(i, j);
					}
				}
			}

			// 0의 개수 빼주기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = map[i][j] - ze[i][j];
					if (map[i][j] <= 0) {
						map[i][j] = 0;
					}
				}
			}
			res++;
		}
	}
}
