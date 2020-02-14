import java.io.*;
import java.util.*;

public class _1546_ЦђБе {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		double map[] = new double[T];
		double max = Double.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<T; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			if(map[i] > max) 
				max = map[i];
		}
		double sum = 0.0;
		for(int i=0; i<T; i++) {
			sum += (map[i]/max)*100.0;
		}
		System.out.printf("%f" , sum/T);
	}
}
