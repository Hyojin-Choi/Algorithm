package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1316_그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean map[] = new boolean[26];
		int cnt = 0;
		for (int t = 0; t < N; t++) {
			boolean flag = true;
			String str = br.readLine();
			int len = str.length();
			for (int i = 0; i < len; i++) {
				int temp = str.charAt(i);
				if (map[temp - 'a']) {
					flag = false;
					break;
				} else {
					if (i < len-1 && temp != str.charAt(i + 1))
						map[temp - 'a'] = true;
				}
			}
			//System.out.println(Arrays.toString(map));
			if (flag == true)
				cnt++;
			for (int i = 0; i < map.length; i++) {
				map[i] = false;
			}
		} // t
		System.out.println(cnt);

	}
}
