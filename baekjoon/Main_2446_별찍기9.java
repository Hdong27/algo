package baekjoon;

import java.util.Scanner;

public class Main_2446_º°Âï±â9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int t = 0; t < N; t++) {
			for (int i = 0; i < t; i++) {
				System.out.print(" ");
			}
			for (int i = 0; i < 2 * (N - t) - 1; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < N - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
