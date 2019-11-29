package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11651_좌표정렬하기2 {
	private static int[][] arr;
	private static int[][] arr2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		
		arr = new int[N][2];
		arr2 = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		partition(0, N - 1);
		
		for (int i = 0; i < N; i++) {
			bw.append(arr2[i][0] + " " + arr2[i][1] + "\n");
		}
		
		bw.flush();
	}
	
	static void partition(int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			partition(left, mid);
			partition(mid + 1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int i = left;
		
		while(l <= mid && r <= right) {
			if(arr[l][1] < arr[r][1]) {
				arr2[i++] = arr[l++];
			} else if(arr[l][1] > arr[r][1]) {
				arr2[i++] = arr[r++];
			} else {
				if(arr[l][0] <= arr[r][0]) {
					arr2[i++] = arr[l++];
				} else {
					arr2[i++] = arr[r++];
				}
			}
		}
		
		while(l <= mid) {
			arr2[i++] = arr[l++];
		}
		
		while(r <= right) {
			arr2[i++] = arr[r++];
		}
		
		for (int j = left; j <= right; j++) {
			arr[j] = arr2[j];
		}
	}
}
