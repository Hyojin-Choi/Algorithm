import java.io.*;
import java.util.*;

public class _1600_말이되고픈원숭이 {
	static int K, N, M;
	static int map[][], check[][][];
	static boolean flag = true;
	static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };
	static int hx[] = {1,2,2,1,-1,-2,-2,-1 }, hy[] = { 2,1,-1,-2,-2,-1,1,2 };
	static boolean range(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > M - 1)
			return false;
		else
			return true;
	}
	static Queue<Point> q = new LinkedList<Point>();
	
	static class Point{
		int x, y, k, cnt;

		public Point(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
		
	}
	public static void bfs(int x, int y, int k, int cnt) {
		check[0][x][y] =1;
		q.add(new Point(x,y,k,cnt));
		
		while(!q.isEmpty()) {
			int qx = q.peek().x;
			int qy = q.peek().y;
			int qk = q.peek().k;
			int qcnt = q.peek().cnt;
			q.poll();
			
			if(qx == N-1 && qy == M-1) {
				flag = false;
				System.out.println(qcnt);
				return;
			}
			
			//K 보다 작으면 들으와 ~~ 
			if(qk < K) {
				for(int i=0; i<8; i++) {
					int nx = qx+hx[i];
					int ny = qy + hy[i];
					int nk = qk +1;
					int ncnt = qcnt +1;
					
					if(range(nx,ny) && map[nx][ny] ==0 && check[nk][nx][ny] == 0) {
						check[nk][nx][ny] = 1;
						q.add(new Point(nx, ny, nk, ncnt));
					}
				}
			}
			
			for(int i=0; i<4; i++) {
				int nx = qx+dx[i];
				int ny = qy +dy[i];
				int nk=qk;
				int ncnt=qk;
				
				if(range(nx,ny) && map[nx][ny] == 0 && check[nk][nx][ny] == 0) {
					check[nk][nx][ny] = 1;
					ncnt = qcnt+1;
					nk = qk;
				
					//System.out.println(" nk : " + nk + " nx : " + nx + " ny : " + ny +  " ncnt : " + ncnt + " i : " + i);
					q.add(new Point(nx, ny, nk, ncnt));
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		check = new int[32][N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0,0,0);
        
		if(flag == true) {
			System.out.println("-1");
		}
	}
}