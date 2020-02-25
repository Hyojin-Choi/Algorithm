package algorithm;

import java.util.Scanner;

public class _6603_로또 {
	static int N;
	static int map[];
	static int check[];

	public static void dfs(int x, int cnt) {
		if(x == N) {
			if(cnt == 6) {
				for(int i=0; i<N; i++) {
					if(check[i] == 1) {
						System.out.print(map[i] + " ");
					}
				}
				System.out.println();
			}
			return;
		}
		
		
		check[x] = 1;
		dfs(x+1, cnt+1);
		check[x]=0;
		dfs(x+1,cnt);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (true) {
			N = s.nextInt();
			
			
			if(N == 0) return;
			map = new int[N];
			check = new int[N];
			for (int i = 0; i < N; i++) {
				map[i] = s.nextInt();
			}
			
			dfs(1,0);
			System.out.println();
		}
	}
}
