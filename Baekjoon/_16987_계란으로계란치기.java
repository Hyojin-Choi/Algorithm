package algorithm;

import java.io.*;
import java.util.*;

public class _16987_계란으로계란치기 {
	static int N;
	static Egg[] eggs;
	static boolean[] isBroker;

	static class Egg {
		int dur;
		int weight;

		public Egg(int dur, int weight) {
			super();
			this.dur = dur;
			this.weight = weight;
		}

	}

	static int ans = 0;

	public static void dfs(int idx, int cnt) {
		ans = Math.max(ans, cnt);
		// 더이상 집을 계란이 없다
		if (idx == N)
			return;
		// 더이상 깰 계란이 없다.
		if (cnt == N - 1)
			return;

		if (eggs[idx].dur <= 0) {
			dfs(idx + 1, cnt);
			return;
		}

		for (int i = 0; i < N; i++) {
			// 내가 나를 칠순없지
			if (i != idx && eggs[i].dur > 0) {
				// i의 내구도는 idx의 무게만큼 감소
				eggs[i].dur -= eggs[idx].weight;
				eggs[idx].dur -= eggs[i].weight;
				// idx의 내구도는 i의 무게만큼 감소
				int nextCnt = cnt;
				if (eggs[i].dur <= 0)
					nextCnt++;
				if (eggs[idx].dur <= 0)
					nextCnt++;
				dfs(idx + 1, nextCnt);

				// 복원
				eggs[i].dur += eggs[idx].weight;
				eggs[idx].dur+= eggs[i].weight;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];
		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			eggs[t] = new Egg(a, b);
			
		}
		
		dfs(0,0);
		System.out.println(ans);

	}
}

