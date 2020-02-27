package algorithm;

import java.io.*;
import java.util.*;

public class _16235_나무재테크 {
	static int N, M, K;
	static int map[][];
	static int start[][];
	static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 }, dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static boolean range(int x, int y) {
		if (x < 1 || x > N || y < 1 || y > N)
			return false;
		else
			return true;
	}

	static class Point implements Comparable<Point> {
		int x, y, age;

		public Point(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", age=" + age + "]";
		}

	}

	static PriorityQueue<Point> q = new PriorityQueue<>();

	public static void namu() {
		ArrayList<Point> die = new ArrayList<>();
		ArrayList<Point> list = new ArrayList<>();
		for (int k = 0; k < K; k++) {
			// 봄
			int qsize = q.size();
			PriorityQueue<Point> newq = new PriorityQueue<>();
			
			for (int i = 0; i < qsize; i++) {
				
				int qx = q.peek().x;
				int qy = q.peek().y;
				int qage = q.peek().age;
				q.poll();
				// 만약 양분이 나이보다 작으면 죽는다
				//System.out.println("qx : " + qx + " qy : " + qy + " start : " + start[qx][qy] + " age : " + qage);

				if( qage <= start[qx][qy]){
					start[qx][qy] -= qage;
					newq.add(new Point(qx, qy, qage + 1));
					
					// 나무나이가 5의 배수이면 인접방향을 나무 나이 1 추가 - 가을
					if ((qage+1) % 5 == 0) {
						list.add(new Point(qx, qy, qage+1));
					}
				}
				else {
					die.add(new Point(qx, qy, qage));
				}
				
			}
			//System.out.print("봄 : ");
			//System.out.println(q.toString());
			q = new PriorityQueue<>(newq);
			// 여름
			for (int i = 0; i < die.size(); i++) {
				int newage = die.get(i).age;
				int qx = die.get(i).x;
				int qy = die.get(i).y;
				
				// 죽은 나무가 양분이 됨
				//System.out.println("newage : " + newage);
				start[qx][qy] +=(int) (newage / 2);

				//for (int i1 = 1; i1 <= N; i1++) {
					//System.out.println(Arrays.toString(start[i1]));
				//}
			}
			die.clear();
			//System.out.println("list : " + list.toString());
			// System.out.println(list.size());
			// 가을
			for (Point p : list) {
				int qx = p.x;
				int qy = p.y;
				// System.out.println("qx : " + qx + " qy : " + qy);
				for (int i = 0; i < 8; i++) {
					int nx = qx + dx[i];
					int ny = qy + dy[i];
					// System.out.println("nx : " + nx + " ny : " + ny);
					if (!range(nx, ny))
						continue;

					q.add(new Point(nx, ny, 1));
				}
			}
			list.clear();

			//System.out.print("가을 : ");
			//System.out.println(q.toString());

			// 겨울
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					start[i][j] = start[i][j] + map[i][j];
				}
			}

		} // k
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		start = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(start[i], 5);
			}
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			q.add(new Point(a, b, c));
		}

		namu();
		System.out.println(q.size());
	}
}

