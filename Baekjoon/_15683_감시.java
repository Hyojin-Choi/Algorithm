package algorithm;

import java.io.*;
import java.util.*;

public class _15683_감시 {
	static int N, M, res, min= Integer.MAX_VALUE;
	static int map[][];
	static int check[][];
	static int dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 };

	static boolean range(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > M - 1)
			return false;
		else
			return true;
	}

	static List<Point> list2 = new ArrayList<>();

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void game(int n) {
		List<Point> list = new ArrayList<>();

		if (n == res) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (check[i][j] == 0 && map[i][j] == 0) {
						cnt++;
					}
				}
			}
			min = Math.min(min, cnt);
			return;
		} // 탈출

		int x = list2.get(n).x;
		int y = list2.get(n).y;
		int nx = x, ny = y;

		if (map[x][y] == 1) {
			for (int i = 0; i < 4; i++) {
				while (range(nx + dx[i], ny + dy[i]) && map[nx + dx[i]][ny + dy[i]] != 6) {
					nx = nx + dx[i];
					ny = ny + dy[i];
					check[nx][ny]++;
					list.add(new Point(nx, ny));
				}
				game(n + 1);
				for (int j = 0; j < list.size(); j++) {
					check[list.get(j).x][list.get(j).y]--;
				}
				list.clear();
				nx = x;
				ny = y;
			}
		}

		if (map[x][y] == 2) {
			nx = x;
			ny = y;
			while (range(nx + dx[0], ny + dy[0]) && map[nx + dx[0]][ny + dy[0]] != 6) {
				nx = nx + dx[0];
				ny = ny + dy[0];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[2], ny + dy[2]) && map[nx + dx[2]][ny + dy[2]] != 6) {
				nx = nx + dx[2];
				ny = ny + dy[2];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();

			nx = x;
			ny = y;
			while (range(nx + dx[1], ny + dy[1]) && map[nx + dx[1]][ny + dy[1]] != 6) {
				nx = nx + dx[1];
				ny = ny + dy[1];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[3], ny + dy[3]) && map[nx + dx[3]][ny + dy[3]] != 6) {
				nx = nx + dx[3];
				ny = ny + dy[3];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();
		} // 2

		if (map[x][y] == 3) { // 3일때
			// 01
			nx = x;
			ny = y;
			while (range(nx + dx[0], ny + dy[0]) && map[nx + dx[0]][ny + dy[0]] != 6) {
				nx = nx + dx[0];
				ny = ny + dy[0];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[1], ny + dy[1]) && map[nx + dx[1]][ny + dy[1]] != 6) {
				nx = nx + dx[1];
				ny = ny + dy[1];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();

			// 12
			nx = x;
			ny = y;
			while (range(nx + dx[1], ny + dy[1]) && map[nx + dx[1]][ny + dy[1]] != 6) {
				nx = nx + dx[1];
				ny = ny + dy[1];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[2], ny + dy[2]) && map[nx + dx[2]][ny + dy[2]] != 6) {
				nx = nx + dx[2];
				ny = ny + dy[2];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();
			// 23
			nx = x;
			ny = y;
			while (range(nx + dx[2], ny + dy[2]) && map[nx + dx[2]][ny + dy[2]] != 6) {
				nx = nx + dx[2];
				ny = ny + dy[2];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[3], ny + dy[3]) && map[nx + dx[3]][ny + dy[3]] != 6) {
				nx = nx + dx[3];
				ny = ny + dy[3];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();
			// 30
			nx = x;
			ny = y;
			while (range(nx + dx[0], ny + dy[0]) && map[nx + dx[0]][ny + dy[0]] != 6) {
				nx = nx + dx[0];
				ny = ny + dy[0];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[3], ny + dy[3]) && map[nx + dx[3]][ny + dy[3]] != 6) {
				nx = nx + dx[3];
				ny = ny + dy[3];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();
		} // 3

		if (map[x][y] == 4) { // 4일때
			// 012
			nx = x;
			ny = y;
			while (range(nx + dx[0], ny + dy[0]) && map[nx + dx[0]][ny + dy[0]] != 6) {
				nx = nx + dx[0];
				ny = ny + dy[0];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[1], ny + dy[1]) && map[nx + dx[1]][ny + dy[1]] != 6) {
				nx = nx + dx[1];
				ny = ny + dy[1];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[2], ny + dy[2]) && map[nx + dx[2]][ny + dy[2]] != 6) {
				nx = nx + dx[2];
				ny = ny + dy[2];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();

			// 123
			nx = x;
			ny = y;
			while (range(nx + dx[3], ny + dy[3]) && map[nx + dx[3]][ny + dy[3]] != 6) {
				nx = nx + dx[3];
				ny = ny + dy[3];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[1], ny + dy[1]) && map[nx + dx[1]][ny + dy[1]] != 6) {
				nx = nx + dx[1];
				ny = ny + dy[1];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[2], ny + dy[2]) && map[nx + dx[2]][ny + dy[2]] != 6) {
				nx = nx + dx[2];
				ny = ny + dy[2];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();

			// 230
			nx = x;
			ny = y;
			while (range(nx + dx[3], ny + dy[3]) && map[nx + dx[3]][ny + dy[3]] != 6) {
				nx = nx + dx[3];
				ny = ny + dy[3];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[0], ny + dy[0]) && map[nx + dx[0]][ny + dy[0]] != 6) {
				nx = nx + dx[0];
				ny = ny + dy[0];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[2], ny + dy[2]) && map[nx + dx[2]][ny + dy[2]] != 6) {
				nx = nx + dx[2];
				ny = ny + dy[2];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();

			// 301
			nx = x;
			ny = y;
			while (range(nx + dx[3], ny + dy[3]) && map[nx + dx[3]][ny + dy[3]] != 6) {
				nx = nx + dx[3];
				ny = ny + dy[3];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[0], ny + dy[0]) && map[nx + dx[0]][ny + dy[0]] != 6) {
				nx = nx + dx[0];
				ny = ny + dy[0];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[1], ny + dy[1]) && map[nx + dx[1]][ny + dy[1]] != 6) {
				nx = nx + dx[1];
				ny = ny + dy[1];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();
		} // 4

		if (map[x][y] == 5) { // 5일때
			nx = x;
			ny = y;
			while (range(nx + dx[3], ny + dy[3]) && map[nx + dx[3]][ny + dy[3]] != 6) {
				nx = nx + dx[3];
				ny = ny + dy[3];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[0], ny + dy[0]) && map[nx + dx[0]][ny + dy[0]] != 6) {
				nx = nx + dx[0];
				ny = ny + dy[0];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[1], ny + dy[1]) && map[nx + dx[1]][ny + dy[1]] != 6) {
				nx = nx + dx[1];
				ny = ny + dy[1];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			nx = x;
			ny = y;
			while (range(nx + dx[2], ny + dy[2]) && map[nx + dx[2]][ny + dy[2]] != 6) {
				nx = nx + dx[2];
				ny = ny + dy[2];
				check[nx][ny]++;
				list.add(new Point(nx, ny));
			}
			game(n + 1);
			for (int j = 0; j < list.size(); j++) {
				check[list.get(j).x][list.get(j).y]--;
			}
			list.clear();
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
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					list2.add(new Point(i, j));
				}
			}
		}
//		for(int i=0; i<list.size(); i++) {
//			System.out.println("listx : " + list.get(i).x);
//			System.out.println("listy : " + list.get(i).y);
//		}
		res = list2.size();
		game(0);
		System.out.println(min);

	}
}
