package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11004_K¹øÂ°¼ö {
	static int[] arr;
	static int[] arr2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		arr2 = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		partition(0, N - 1);
		
		System.out.println(arr2[K - 1]);
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
		
		while(l <= mid & r <= right) {
			if(arr[l] <= arr[r]) {
				arr2[i++] = arr[l++];
			} else {
				arr2[i++] = arr[r++];
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
