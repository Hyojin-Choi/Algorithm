package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class _1057_토너먼트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int all = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int imm = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		
		if(all < kim || all < imm) cnt--;
		else {
			while(kim != imm) {
				kim = (kim+1) / 2;
				imm = (imm+1) / 2;
				cnt ++;
			}
		}
		
		System.out.println(cnt);
	}
}
