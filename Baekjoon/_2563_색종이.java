import java.util.Scanner;

public class _2563_»öÁ¾ÀÌ {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		int map[][] = new int[101][101];
		
		for(int t=0; t<T; t++) {
			int N = s.nextInt();
			int M = s.nextInt();
			
			for(int i=N; i<N+10; i++) {
				for(int j=M; j<M+10; j++) {
					map[i][j] = 1;
				}
			}
		}
		int cnt = 0;
		
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(map[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
