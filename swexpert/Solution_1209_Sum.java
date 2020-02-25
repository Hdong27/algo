package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1209_Sum {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int testCase = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < 100; i++) {
				int temp = 0;
				for (int j = 0; j < 100; j++) {
					temp += arr[i][j];
				}
				
				max = temp > max ? temp : max;
				
				temp = 0;
				for (int j = 0; j < 100; j++) {
					temp += arr[j][i];
				}
				
				max = temp > max ? temp : max;
			}
			
			// ´ë°¢¼±
			int temp = 0;
			for (int i = 0; i < 100; i++) {
				temp += arr[i][i];
			}
			
			max = temp > max ? temp : max;
			
			temp = 0;
			for (int i = 0; i < 100; i++) {
				temp += arr[i][99 - i];
			}
			
			max = temp > max ? temp : max;
			
			System.out.println("#" + testCase + " " + max);
		}
	}
}
