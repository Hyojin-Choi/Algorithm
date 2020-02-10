package algorithm;

import java.io.*;
import java.util.*;

public class _17822_원판돌리기 {
	static int N, M, K, x, d, k;
	static int map[][];
	static int check[][];

	static void turn(int n, int m, int cnt) {
		// 시계
		while (true) {
			if (n <= N) {
				if (m == 0) {
					for (int i = 0; i < cnt; i++) {
						int temp = map[n - 1][M - 1];
						for (int j = M - 1; j > 0; j--) {
							map[n - 1][j] = map[n - 1][j - 1];
						}
						map[n - 1][0] = temp;
					}
				}
				// 반시계
				else if (m == 1) {
					for (int i = 0; i < cnt; i++) {
						int temp = map[n - 1][0];
						for (int j = 0; j < M - 1; j++) {
							map[n - 1][j] = map[n - 1][j + 1];
						}
						map[n - 1][M - 1] = temp;
					}
				}
				if (n >= 2) {
					n = n * 2;
				} else if (n < 2) {
					n = N + 1;
				}
			} else {
				boolean flag = true;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						check[i][j] = 0;
					}
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M - 1; j++) {
						if (map[i][j] != 0) {
							if (map[i][j] == map[i][j + 1]) {
								flag = false;
								check[i][j] = 1;
								check[i][j + 1] = 1;
							}
						}
					}
					if (map[i][0] != 0) {
						if (map[i][0] == map[i][M - 1]) {
							flag = false;
							check[i][0] = 1;
							check[i][M - 1] = 1;
						}
					}
				}
				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N - 1; j++) {
						if (map[j][i] != 0) {
							if (map[j][i] == map[j + 1][i]) {
								flag = false;
								check[j][i] = 1;
								check[j + 1][i] = 1;
							}
						}
					}
				}
				if (flag == false) {
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (check[i][j] == 1) {
								map[i][j] = 0;
							}
						}
					}
				} else if (flag == true) {
					int s = 0, c = 0;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							s += map[i][j];
							if (map[i][j] != 0)
								c++;
						}
					}
					if (c != 0) {
						double avg = (double) s / c;
						for (int i = 0; i < N; i++) {
							for (int j = 0; j < M; j++) {
								if (map[i][j] != 0 && map[i][j] > avg) {
									map[i][j] -= 1;
								} else if (map[i][j] != 0 && map[i][j] < avg) {
									map[i][j] += 1;
								}
							}
						}
					}
				}
				break;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			turn(x, d, k);
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
			}
		}

		System.out.println(sum);
	}
}
