package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_퇴사 {
	static int T;
	static int tmap[];
	static int pmap[];
	static int max = Integer.MIN_VALUE;
	
	static public void dfs(int x, int sum) {
		
		if(x>T) {
			return;
		}
		
		if(x == T) {
			
			if(max < sum) {
				max = sum;
			}
			return;
		}
		
		dfs(x+tmap[x] , sum + pmap[x]);
		dfs(x+1, sum);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		tmap = new int[T];
		pmap = new int[T];
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tmap[i] = Integer.parseInt(st.nextToken());
			pmap[i] = Integer.parseInt(st.nextToken());
		}
		
		//for(int i=0; i<T; i++) {
			dfs(0,0);
		//}
		
		System.out.println(max);
		//System.out.println(Arrays.toString(tmap));
		//System.out.println(Arrays.toString(pmap));

	}
}
