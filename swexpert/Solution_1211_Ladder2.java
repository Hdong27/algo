package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1211_Ladder2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int testCase = Integer.parseInt(br.readLine().trim());
			
			int[][] arr = new int[100][100];
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 100; i++) {
				if(arr[0][i] == 1) {
					int length = 0;
					boolean[][] check = new boolean[100][100];
					int[] location = new int[] {0, i};
					check[0][i] = true;
					
					while(location[0] < 99) {
						if(location[1] - 1 >= 0 && arr[location[0]][location[1] - 1] == 1 && !check[location[0]][location[1] - 1]) {
							location[1]--;
							check[location[0]][location[1]] = true;
						} else if(location[1] + 1 < 100 && arr[location[0]][location[1] + 1] == 1 && !check[location[0]][location[1] + 1]) {
							location[1]++;
							check[location[0]][location[1]] = true;
						} else if(arr[location[0] + 1][location[1]] == 1) {
							location[0]++;
							check[location[0]][location[1]] = true;
						}
						
						length++;
					}
					
					if(length <= min) {
						index = i;
						min = length;
					}
				}
			}
			
			System.out.println("#" + testCase + " " + index);
		}
	}
}
