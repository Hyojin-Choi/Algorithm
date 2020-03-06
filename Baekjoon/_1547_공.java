package algorithm;

import java.io.*;
import java.util.*;

public class _1547_공 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[] = new int[4];

		for (int i = 1; i <= 3; i++) {
			map[i] = i;
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int temp = 0;

			temp = map[a];
			map[a] = map[b];
			map[b] = temp;

		}
		int cnt = 0;
		for (int i = 1; i <= 3; i++) {
			if (map[i] == 1) {
				System.out.println(i);
				break;
			} else
				cnt++;

		}
		
		if(cnt == 3) {
			System.out.println("-1");
		}

	}
}
