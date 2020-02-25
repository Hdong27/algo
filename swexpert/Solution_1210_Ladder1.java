package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int testCase = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[100][100];
			int[] finish = new int[2];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 2) {
						finish = new int[] {i, j};
					}
				}
			}
			
			while(finish[0] > 0) {
				arr[finish[0]][finish[1]] = 0;
				if(finish[1] - 1 >= 0 && arr[finish[0]][finish[1] - 1] == 1) {
					finish[1]--;
				} else if(finish[1] + 1 < 100 && arr[finish[0]][finish[1] + 1] == 1) {
					finish[1]++;
				} else if(arr[finish[0] - 1][finish[1]] == 1) {
					finish[0]--;
				}
			}
			
			System.out.println("#" + testCase + " " + finish[1]);
		}
	}
}
