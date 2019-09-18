package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_8500_±ÿ¿Â¡¬ºÆ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int[] num = new int[N];
			
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(num);
			
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				result += num[i];
			}
			
			result += num[N-1] + N;
			
			System.out.println("#" + t + " " + result);
		}
	}
}
