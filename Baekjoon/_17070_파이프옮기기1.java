package algorithm;

import java.util.Scanner;

public class _17070_파이프옮기기1 {
   static int dr[] = {0,1,1};
   static int dc[] = {1,1,0};
   static int map[][];
   static int N;
   static int cnt=0;
   
   static void dfs(int r, int c, int dir) {
      if(r==N && c==N) {
         cnt++;
         return;
      }
      
      for(int i=0; i<3; i++) {
         if(dir==0) {
            if(i==2)
               continue;
         }else if(dir==2) {
            if(i==0)
               continue;
         }
         
         int nr = r+dr[i];
         int nc = c+dc[i];
         
         if(i==0 || i==2) {
            if(nr<1|| nc<1 || nr>N || nc>N || map[nr][nc]==1 )
               continue;
         }else if (i == 1) {
               if (nr > N || nc > N || map[nr][nc] == 1 || map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1) continue;
           }

           dfs(nr, nc, i);
      }
   }
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();

      map = new int[N+1][N+1];

      for (int i = 1; i <= N; i++) {
         for (int j = 1; j <= N; j++) {
            map[i][j] = sc.nextInt();
         }
      }
      
      dfs(1,2,0);
      System.out.println(cnt);
   }
}