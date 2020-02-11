package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//순열
public class _15649_N과M1 {
	static int N;
	static int M;
	static int map[];
	static boolean check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N];
		check = new boolean[N];

		dfs(0);
	}

	static public void dfs(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(map[i] + " ");
			}
			System.out.println();
			return;
		}

		// 순열
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				map[idx] = i + 1;
				dfs(idx + 1);
				check[i] = false;
			}
		}
	}
}
