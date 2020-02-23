package algorithm;

import java.io.*;
import java.util.*;

public class _17135_캐슬디펜스 {
	static int N, M, D;
	static int map[][], check[];
	static int sel[], dir[];

	static class Point implements Comparable<Point> {
		int x, y, cnt;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Point o) {
			if (cnt == o.cnt) {
				return this.x - o.x;
			}
			return cnt - o.cnt;
		}

	}

	public static void dfs(int idx, int cnt) {
		if (cnt == 3) {
			System.out.println();

			System.out.print("sel : ");
			System.out.println(Arrays.toString(sel));
			// 여기서 화살쏴라 -_-;;

			// 우리 거리부터 구하자ㅏㅏ
			int qsize = list.size();
			for (int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				int a = 0, b = 0;
				for (int i = 0; i < qsize; i++) {
					int qx = list.get(i).x;
					int qy = list.get(i).y;

					int abs = Math.abs(N - qx) + Math.abs(sel[j] - qy);
					if (min > abs) {
						min = abs;
						a = qx;
						b = qy;
					}
//					System.out.print("qx : " + qx + "qy : " + qy + " dir : ");
//					System.out.println(Arrays.toString(dir));
				}
				dir[j] = min;
				pq.add(new Point(a, b, min));

				//짧은 애를 없애자 
				
			}
//			System.out.println(Arrays.toString(dir));
//			System.out.println(pq);
			return;
		}

		if (idx == M)
			return;

		sel[cnt] = idx;
		dfs(idx + 1, cnt + 1);
		dfs(idx + 1, cnt);
	}

	static List<Point> list = new ArrayList<>();
	static PriorityQueue<Point> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M];
		sel = new int[3];
		dir = new int[3];
		check = new int[3];

		Arrays.fill(dir, Integer.MAX_VALUE);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					list.add(new Point(i, j));
			}
		}
		dfs(0, 0);
	}
}