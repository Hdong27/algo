package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2822_점수계산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Num[] arr = new Num[9];
		arr[0] = new Num(0, -1);
		
		for (int i = 1; i <= 8; i++) {
			arr[i] = new Num(i, Integer.parseInt(br.readLine().trim()));
		}
		
		Arrays.sort(arr);
		
		int score = 0;
		int[] index = new int[5];
		for (int i = 0; i < 5; i++) {
			score += arr[i].score;
			index[i] = arr[i].index;
		}
		
		Arrays.sort(index);
		
		System.out.println(score);
		
		for (int i = 0; i < 5; i++) {
			System.out.print(index[i] + " ");
		}
	}
	
	static class Num implements Comparable<Num>{
		int index;
		int score;
		
		public Num(int index, int score) {
			this.index = index;
			this.score = score;
		}

		@Override
		public int compareTo(Num o) {
			return o.score - this.score;
		}
	}
}
