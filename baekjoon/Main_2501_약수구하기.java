package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2501_약수구하기 {
	public static void main(String[] args) throws Exception {
		// N(숫자), K(번째) 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(K == 1) {
			System.out.println(1);
			return;
		}
		
		int answer = 0;
		int count = 2;
		
		for (int i = 2; i <= N; i++) {
			if(N % i == 0) {
				if(count == K) {
					answer = i;
					break;
				}
				count++;
			}
		}
		
		System.out.println(answer);
	}
}
