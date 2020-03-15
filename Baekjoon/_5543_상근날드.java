package algorithm;

import java.util.Scanner;

public class _5543_상근날드 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int map[] = new int[5];

		for (int i = 0; i < 5; i++) {
			map[i] = s.nextInt();
		}
		int mn = 123456778;
		for (int i = 0; i < 3; i++) {
			if (mn > map[i])
				mn = map[i];
		}
		int mn2 = 12345666;
		for (int i = 3; i < 5; i++) {
			if (mn2 > map[i])
				mn2 = map[i];
		}
		System.out.println(mn + mn2 - 50);
	}
}
