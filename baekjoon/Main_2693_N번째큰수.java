package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2693_N번째큰수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 0; t < T; t++) {
			int[] arr = new int[10];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			System.out.println(arr[7]);
		}
	}
}
