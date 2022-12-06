package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2460_지능형기차2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		int num = 0;
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			num -= Integer.parseInt(st.nextToken());
			num += Integer.parseInt(st.nextToken());
			
			if(num > answer) answer = num;
		}
		
		System.out.println(answer);
	}
}
