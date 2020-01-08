import java.io.*;
import java.util.*;

public class _17471_�Ը��Ǵ���_dfs {
	static int N; // ���ű��� ����
	static int[] voters; // �� ���ű��� ������ ��
	static int[][] adj; // ���ű� ���� ���� ����
	static boolean[] sel; // ���ű��� true/ false ���������� ����
	static int ans = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		voters = new int[N + 1];
		adj = new int[N + 1][N + 1];
		sel = new boolean[N + 1];
		visited = new boolean[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			voters[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= cnt; j++) {
				int a = Integer.parseInt(st.nextToken());
				adj[i][a] = 1;
				adj[a][i] = 1;
			}
		}
		powerset(1);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	static public void powerset(int idx) {
		if (idx == N + 1) {
			// �� ���� ������ ���μ��� ��� �������� �˻��ؼ� true/ false ����
			if (check()) {
				int sumA = 0;
				int sumB = 0;

				for (int i = 1; i <= N; i++) {
					if (sel[i])
						sumA += voters[i];
					else
						sumB += voters[i];
				}
				ans = Math.min(ans, Math.abs(sumA - sumB));
			}

			return;
		}

		sel[idx] = true;
		powerset(idx + 1);
		sel[idx] = false;
		powerset(idx + 1);
	}

	static boolean check() {
		List<Integer> areaA = new ArrayList<>();
		List<Integer> areaB = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (sel[i])
				areaA.add(i);
			else
				areaB.add(i);
		}

		if (areaA.size() == 0 || areaB.size() == 0)
			return false;

		if (areaA.size() > 0)
			dfs(1);

		if (areaB.size() > 0)
			dfs(1);
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	static public void dfs(int idx) {
		visited[idx] = true;
		if(idx == N) {
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && sel[i] && adj[i][idx] == 1) {
				dfs(i);
			}
		}
	}
}