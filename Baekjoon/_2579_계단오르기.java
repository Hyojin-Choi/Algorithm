package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2579_계단오르기 {

   public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      int[] map = new int[N];
      int[] check = new int[N];
      for (int i = 0; i < N; i++) {
         check[i] = Integer.parseInt(br.readLine());
      }

      map[0] = check[0];
      if(check[0] +check[1] < check[1]) {
    	  map[1] = check[1];
      }
      else {
    	  map[1] = check[0]+check[1];
      }
      if(check[0] + check[2] < check[1]+check[2]) {
    	  map[2] = check[1] + check[2];
      }
      else {
    	  map[2] = check[0] + check[2];
      }

      //System.out.println(Arrays.toString(map));
      
      for(int i=3; i<N; i++) {
    	  if(map[i-2] + check[i] < check[i] + check[i-1] + map[i-3]) {
    		  map[i] =check[i] + check[i-1] + map[i-3];
    	  }
    	  else {
    		  map[i] = map[i-2] + check[i];
    	  }
          //System.out.println(Arrays.toString(map));

      }
      
      System.out.println(map[N-1]);
   }
}