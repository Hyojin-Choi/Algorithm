package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2564_경비원 {
	static int mi = 0, mj = 0;
	static int N, M, T;
	static int a, b, res;
	static int map[][];
	static int check[][];
	static int mapcnt;

	public static void ham(int x, int y) {
		int ban = 0;
		int si = 0;
		// 일단 동근이가 있는 자리를 구하자
		// 동근이가 1번에 있을때
		if (mi == 1 && check[mi][mj] == 1) {
			// 상점 1번
			if (x == 1 && check[x][y] == 1) {
				si += y - mj;
				int rrr = 0;
				rrr = Math.abs(si);
				res += rrr;
			}

			// 상점 2번
			if (x == N && check[x][y] == 2) {
				si += y;
				si += mj;
				si += N;
				ban = mapcnt - si;
				if (ban < si)
					res += ban;
				else
					res += si;
			}

			// 상점 3번
			if (y == 1&& check[x][y] == 3) {
				si += mj + x;
				ban = mapcnt - si;
				if (ban < si)
					res += ban;
				else
					res += si;
			}

			// 상점 4번
			if (y == M && check[x][y] == 4) {
				si += N + M + mj + (N - x);
				ban = mapcnt - si;
				if (ban < si)
					res += ban;
				else
					res += si;
			}
		}

		// 동근이 2번
		if (mi == N&& check[mi][mj] == 2) {
			// 상점 1번
			if (x == 1&& check[x][y] == 1) {
				si += y;
				si += mj;
				si += N;
				ban = mapcnt - si;
				if (ban < si)
					res += ban;
				else
					res += si;
			}

			// 상점 2번
			if (x == N&& check[x][y] == 2) {
				si += y - mj;
				int rrr = 0;
				rrr = Math.abs(si);
				res += rrr;
			}

			// 상점 3번
			if (y == 1&& check[x][y] == 3) {
				si += mj + (N - x);
				ban = mapcnt - si;
				if (ban < si)
					res += ban;
				else
					res += si;
			}

			// 상점 4번
			if (y == M&& check[x][y] == 4) {
				si += N + M + mj + x;
				ban = mapcnt - si;
				if (ban < si)
					res += ban;
				else
					res += si;
			}
		}

		// 동근이 3번
		if (mj == 1&& check[mi][mj] == 3) {
			if (x == 1&& check[x][y] == 1) {
				si += mi + y;
				ban = mapcnt - si;

				if (ban < si)
					res += ban;
				else
					res += si;
			}

			// 상점 2번
			if (x == N&& check[x][y] == 2) {
				si += M + N + mi + (M - y);
				ban = mapcnt - si;

				if (ban < si)
					res += ban;
				else
					res += si;
			}

			// 상점 3번
			if (y == 1&& check[x][y] == 3) {
				si += x - mi;
				int rrr = 0;
				rrr = Math.abs(si);
				res += rrr;
			}

			// 상점 4번

			if (y == M&& check[x][y] == 4) {
				si += M + mi + x;
				ban = mapcnt - si;
				if (ban < si)
					res += ban;
				else
					res += si;
			}
		}

		// 동근이 4번
		if (mj == M&& check[mi][mj] == 4) {
			if (x == 1&& check[x][y] == 1) {
				si += mi + (M - y);
				ban = mapcnt - si;
				if (ban < si)
					res += ban;
				else
					res += si;
			}

			// 상점 2번
			if (x == N&& check[x][y] == 2) {
				si += N + M + x + mi;
				ban = mapcnt - si;
				if (ban < si)
					res += ban;
				else
					res += si;
			}

			// ------------------------

			// 상점 3번

			if (y == 1&& check[x][y] == 3) {
				si += M + x + mi;
				ban = mapcnt - si;
				if (ban < si)
					res += ban;
				else
					res += si;
			}

			// 상점 4번

			if (y == M&& check[x][y] == 4) {
				si += x - mi;
				int rrr = 0;
				rrr = Math.abs(si);
				res += rrr;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		check = new int[N + 1][M + 1];

		mapcnt = N + N + M + M;

		T = Integer.parseInt(br.readLine());

		int idx = 1;
		for (int i = 1; i <= T + 1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (i == T + 1) {
				if (a == 1) {
					map[1][b] = -1;
					check[1][b] = a;
				}
				if (a == 2) {
					map[N][b] = -1;
					check[N][b] = a;
				}
				if (a == 3) {
					map[b][1] = -1;
					check[b][1] = a;
				}
				if (a == 4) {
					map[b][M] = -1;
					check[b][M] = a;
				}
			} else {
				if (a == 1) {
					map[1][b] = idx;
					check[1][b] = a;
				}
				if (a == 2) {
					map[N][b] = idx;
					check[N][b] = a;
				}
				if (a == 3) {
					map[b][1] = idx;
					check[b][1] = a;
				}
				if (a == 4) {
					map[b][M] = idx;
					check[b][M] = a;
				}
				idx++;
			}
		}
//		System.out.println();
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//
//		}
//		System.out.println();
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(check[i]));
//
//		}
		// 1번인 경우
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == -1) {
					mi = i;
					mj = j;
				}
			}
		}
//		System.out.println("mi : " + mi);
//		System.out.println("mj : " + mj);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] > 0) {
//					System.out.println("i : " + i);
//					System.out.println("j : " + j);
					ham(i, j);
				}
			}
		}
		System.out.println(res);
	}
}