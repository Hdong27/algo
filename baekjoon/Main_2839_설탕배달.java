package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i <= N / 5; i++) {
			// i = 5kg의 봉지 개수
			int count = i;
			int temp = N - i * 5;	// 남은 kg수
			if(temp % 3 == 0) {	// 모두 담을 수 있으면
				count += temp / 3;
				result = result > count ? count : result;
			}
		}
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
}
