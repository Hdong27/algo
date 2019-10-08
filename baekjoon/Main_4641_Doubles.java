package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4641_Doubles {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
loop:	while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			boolean[] check = new boolean[100];
			
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				if(n == -1) break loop;
				
				check[n] = true;
			}
			
			int result = 0;
			
			for (int i = 1; i < 50; i++) {
				if(check[i] && check[i * 2]) {
					result++;
				}
			}
			
			System.out.println(result);
			
		}
	}
}
