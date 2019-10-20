package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8741_두문자어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			sb.append('#').append(t).append(' ');
			for (int i = 0; i < 3; ++i) {
				sb.append((char)(st.nextToken().charAt(0) - 32));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
