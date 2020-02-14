import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_123¥ı«œ±‚ {
	static int T, N;
	static int cnt;

	public static void dfs(int x) {
		if (x == N) {
			cnt++;
			return;
		}
		
		else if(N < x) {
			return;
		}
		
		for(int i=1; i<=3; i++) {
			dfs(x+i);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			dfs(0);
			System.out.println(cnt);
		}
	}
}
