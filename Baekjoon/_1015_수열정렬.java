package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1015_수열정렬 {
	static int T;
	static Point map[];
	static int B[];
	static class Point implements Comparable<Point>{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		map = new Point[T];
		B = new int[T];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			map[i] = new Point(Integer.parseInt(st.nextToken()),i);
		}
		Arrays.sort(map);
		
		for(int i=0; i<T; i++) {
			B[map[i].y] = i;
		}
		
		for(int i=0; i<T; i++) {
			System.out.print(B[i] + " ");
		}
		
	}
}
