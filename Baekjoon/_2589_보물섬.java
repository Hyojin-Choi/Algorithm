package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589_보물섬 {
	static int N,M;
	static int res;
	static char map[][];
	static int check[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	static boolean range(int x, int y) {
		if(x<0|| x>N-1 || y< 0|| y>M-1) return false;
		else return true;
	}
	
	static class Point{
		int x,y,cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static Queue<Point> q = new LinkedList<>();
	
	public static void bfs(int x, int y) {
		check[x][y] = 1;
		q.add(new Point(x,y,0));
		
		while(!q.isEmpty()) {
			int qx = q.peek().x;
			int qy = q.peek().y;
			int qcnt = q.peek().cnt;
			q.poll();
			
			if(qcnt > res) {
				res = qcnt;
			}
			
			for(int i=0; i<4; i++) {
				int nx = qx+dx[i];
				int ny= qy+dy[i];
				
				if(range(nx,ny) && map[nx][ny] == 'L' && check[nx][ny] == 0) {
					check[nx][ny] = 1;
					q.add(new Point(nx,ny,qcnt+1));
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new char[N][M];
		check = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str= br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'L') {
					bfs(i,j);
					for(int k=0; k<N; k++) {
						for(int p=0; p<M; p++) {
							check[k][p]=0;
						}
					}
				}
			}
		}
		
		System.out.println(res);
		
	}
}
