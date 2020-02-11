import java.util.*;
import java.io.*;

public class _17825_¡÷ªÁ¿ß¿∑≥Ó¿Ã {
	static int way[][] = { { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 },
			{ 10, 13, 16, 19, 25, 30, 35, 40 }, { 20, 22, 24, 25, 30, 35, 40 }, { 30, 28, 27, 26, 25, 30, 35, 40 } };
	static int command[], work[], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		command = new int[10];
		work = new int[10];
		for (int i = 0; i < 10; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
		answer = Integer.MIN_VALUE;
		setCommand(0);
		System.out.println(answer);
	}

	static void setCommand(int v) {
		if (v == 10) {
			int val = Game();
			answer = answer < val ? val : answer;
			return;
		}
		for (int i = 0; i < 4; i++) {
			work[v] = i;
			setCommand(v + 1);
		}
	}

	static int Game() {
		int score = 0;
		int horse[][] = new int[4][2];
		for (int c = 0; c < 10; c++) {
			int cur = work[c];
			if (horse[cur][1] == 0 && horse[cur][0] % 5 == 0) {
				int val = horse[cur][0] / 5;
				if (1 <= val && val <= 3) {
					horse[cur][1] = val;
					horse[cur][0] = 0;
				}
			}
			horse[cur][0] += command[c];
			int cv = horse[cur][0];
			int cf = horse[cur][1];

			for (int iter = 0; iter < 4; iter++) {
				if (iter == cur)
					continue;
				int nv = horse[iter][0];
				int nf = horse[iter][1];
				if (way[cf].length > cv && way[nf].length > nv) {
					if (cv == nv && cf == nf)
						return Integer.MIN_VALUE;
					if (cf != 0 && nf != 0 && way[cf][cv] == way[nf][nv])
						return Integer.MIN_VALUE;
					if (way[cf][cv] == 40 && way[nf][nv] == 40)
						return Integer.MIN_VALUE;
				}
			}
			if (cv < way[cf].length)
				score += way[cf][cv];
		}
		return score;
	}
}