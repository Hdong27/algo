package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int testCase = Integer.parseInt(br.readLine().trim());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[8];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				min = arr[i] < min ? arr[i] : min;
			}
			
			int temp = (min / 15 - 1) * 15;
			
			for (int i = 0; i < 8; i++) {
				arr[i] -= temp;
			}
			
			int index = 0;
			int n = 1;
			// 사이클 돌리기
			while(true) {
				arr[index] -= n;
				
				if(arr[index] <= 0) {
					arr[index] = 0;
					break;
				}
				
				n = n == 5 ? 1 : n + 1;
				index = index == 7 ? 0 : index + 1;
			}
			
			System.out.print("#" + t + " ");
			for (int i = index + 1; i < 8; i++) {
				System.out.print(arr[i] + " ");
			}
			for (int i = 0; i <= index; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}
