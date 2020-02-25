package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int K = Integer.parseInt(br.readLine().trim());
			
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			while(K > 0 || arr[99] - arr[0] <= 1) {
				Arrays.sort(arr);
				arr[99]--;
				arr[0]++;
				K--;
			}
			
			Arrays.sort(arr);
			System.out.println("#" + t + " " + (arr[99] - arr[0]));
		}
	}
}
