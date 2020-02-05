package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 톱니바퀴 {
	static int map[][] = new int[4][8];
	static int K, N, M, B, cnt, sum;
	static int top[] = new int[4];

	public static void find(int x, int y) {
		int nx = x;
		top[nx] = y;
		while (nx + 1 < 4 && map[nx][2] != map[nx + 1][6]) {
			System.out.println("111");
			top[nx + 1] = -y;
			y = -y;
			nx = nx + 1;
		}
		System.out.println("x : " + x);
		nx = x;
		while (nx - 1 >= 0 && map[nx][6] != map[nx - 1][2]) {
			System.out.println("222");
			top[nx - 1] = -y;
			y = -y;
			nx = nx - 1;
		}
	}

	public static void turn() {
		int temp[][] = new int[4][8];

		for (int i = 0; i < top.length; i++) {
			if (top[i] == 0)
				continue;

			if (top[i] == 1) {
				for (int j = 0; j < 8; j++) {
					if (j == 7) {
						temp[i][0] = map[i][j];
					} else {
						temp[i][j + 1] = map[i][j];
					}
				}
			}
			if (top[i] == -1) {
				for (int j = 7; j >= 0; j--) {
					if (j == 0) {
						temp[i][7] = map[i][j];
					} else {
						temp[i][j - 1] = map[i][j];
					}
				}
			}
			map[i] = temp[i];

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			Arrays.fill(top, 0);

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			find(N - 1, M);

			for (int j = 0; j < 4; j++) {
				System.out.println(Arrays.toString(map[j]));
			}
			System.out.println(Arrays.toString(top));

			int cntcheck = 0;
			for (int k = 0; k < 4; k++) {
				if (top[k] == 0) {
					cntcheck++;
				}
			}

			turn();

			System.out.println();
			for (int j = 0; j < 4; j++) {
				System.out.println(Arrays.toString(map[j]));
			}

			if (K - 1 == i)
				continue;

			Arrays.fill(top, 0);

		}
		for (int j = 0; j < 4; j++) {
			if (map[j][0] == 1) {
				if (j == 0)
					sum += 1;
				if (j == 1)
					sum += 2;
				if (j == 2)
					sum += 4;
				if (j == 3)
					sum += 8;
			}
		}
		System.out.println(sum);

	}
}