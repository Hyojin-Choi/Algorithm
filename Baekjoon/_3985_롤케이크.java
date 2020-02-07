import java.util.Arrays;
import java.util.Scanner;

public class _3985_롤케이크 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();
		int N = s.nextInt();

		int map[] = new int[T + 1];
		int check[] = new int[T + 1];

		int idx = 1;
		int ares = 0;
		int mx = Integer.MIN_VALUE;
		for (int t = 0; t < N; t++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int res = b - a;

			if (res > mx) {
				mx = res;
				ares = idx;
			}

			for (int i = a; i <= b; i++) {
				if (map[i] == 0) {
					map[i] = idx;
				}
			}
			idx++;
		}
		System.out.println(ares);
		for (int i = 1; i <= T; i++) {
			check[map[i]]++;
		}
		int max = Integer.MIN_VALUE;
		int resmax = 0;
		for(int i=1; i<=T; i++) {
			if(max < check[i]) {
				max = check[i];
				resmax = i;
			}
		}
		
		System.out.println(resmax);
	}
}