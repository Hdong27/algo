package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10039_Æò±ÕÁ¡¼ö {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int score = Integer.parseInt(br.readLine().trim());
			sum += score < 40 ? 40 : score;
		}
		
		System.out.println(sum / 5);
	}
}
