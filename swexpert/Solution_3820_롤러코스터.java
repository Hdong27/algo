package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3820_롤러코스터 {
	static int limit = 1000000007;
	static Rail[] rails;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			rails = new Rail[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				rails[i] = new Rail(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// sort와 Comparable을 이용해서 구현
			// 식 : (Ai+1 - 1) * Bi <= (Ai - 1) * Bi+1
			
			Arrays.sort(rails);
			
			long result = 1;
			for (int i = 0; i < N; i++) {
				result = result * rails[i].a + rails[i].b;
				result %= limit;
			}
		
			System.out.println("#" + t + " " + result);
		}
	}
	
	static class Rail implements Comparable<Rail>{
		long a;
		long b;
		
		public Rail(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Rail o) {
			if ((this.b * (o.a - 1) - o.b * (this.a - 1)) > 0) {
				return -1; 
			}
			return 0;
		}

	}
	
}
