package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_View {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int result = 0;
			
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 2; i < N - 2; i++) {
				// ¿ÞÂÊ 2Ä­°ú ¿À¸¥ÂÊ 2Ä­À» ºñ±³ÇÑ´Ù
				int max = 256;
				if(arr[i] - arr[i-2] > 0) {
					max = arr[i] - arr[i-2] < max ? arr[i] - arr[i-2] : max;
				} else {
					continue;
				}
				if(arr[i] - arr[i-1] > 0) {
					max = arr[i] - arr[i-1] < max ? arr[i] - arr[i-1] : max;
				} else {
					continue;
				}
				if(arr[i] - arr[i+1] > 0) {
					max = arr[i] - arr[i+1] < max ? arr[i] - arr[i+1] : max;
				} else {
					continue;
				}
				if(arr[i] - arr[i+2] > 0) {
					max = arr[i] - arr[i+2] < max ? arr[i] - arr[i+2] : max;
				} else {
					continue;
				}
				
				result += max;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
