package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _15686_치킨배달 {
	static int N, M, res;
	static int map[][];
	static ArrayList<Point> house;
	static ArrayList<Point> chi;
	static boolean check[];
	static Point[] sel_chi;
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void dfs(int cnt, int idx) {
		if(idx == M) {
			int temp = 0;
			for(int i=0; i<house.size(); i++) {
				int dis = Integer.MAX_VALUE;
				int housex = house.get(i).x;
				int housey = house.get(i).y;
				
				for(int j=0; j<M; j++) {
					int chix = sel_chi[j].x;
					int chiy = sel_chi[j].y;
					//System.out.println("chix : " + chix + " chiy : " + chiy);
					int ch_dis = Math.abs(housex - chix) + Math.abs(housey - chiy);
					if(ch_dis < dis) dis = ch_dis;
				}
				temp += dis;
			}
			res = Math.min(res, temp);
		}
		
		if(cnt == chi.size()) return;
		
		sel_chi[idx] = chi.get(cnt);
		dfs(cnt+1, idx+1);
		dfs(cnt+1, idx);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		chi = new ArrayList<>(); 
		house = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					house.add(new Point(i, j));
				if (map[i][j] == 2) {
					chi.add(new Point(i, j));
				}
			}
		}

		check = new boolean[chi.size()];
		sel_chi = new Point[M];

		dfs(0, 0);

		System.out.println(res);
	}
}
