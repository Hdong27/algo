package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12101_123¥ı«œ±‚2 {
	static int N, K;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		flag = false;
		dfs("", 0);
		
		if(!flag) {
			System.out.println(-1);
		}
	}
	
	static void dfs(String result, int sum) {
		if(flag) {
			return;
		}
		
		if(sum == N) {
			K--;
			if(K == 0) {
				for (int i = 0; i < result.length() - 1; i++) {
					System.out.print(result.charAt(i) + "+");
				}
				System.out.println(result.charAt(result.length() - 1));
				flag = true;
				return;
			}
			return;
		}
		
		if(sum > N) {
			return;
		}
		dfs(result + "1", sum + 1);
		dfs(result + "2", sum + 2);
		dfs(result + "3", sum + 3);
	}
}
