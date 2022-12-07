package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int result = 1;
		
		for (int i = 2; i <= a && i <= b; i++) {
			if(a % i == 0 && b % i == 0) {
				result = i;
			}
		}
		
		System.out.println(result);
		System.out.println(result * (a / result) * (b / result));
	}
}
