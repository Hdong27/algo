package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_백만장자프로젝트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long result = 0;
			
			int temp = arr[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				if(temp >= arr[i]) {
					result += temp - arr[i];
				} else {
					temp = arr[i];
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
