package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10989_수정렬하기3 {
	private static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] num = new int[10001];
		for (int i = 0; i < N; i++) {
			num[Integer.parseInt(br.readLine().trim())]++;
		}
		
		for (int i = 1; i <= 10000; i++) {
			for (int j = 0; j < num[i]; j++) {
				bw.append(i + "\n");
			}
		}
		
		bw.flush();
	}
	
	static void quickSort(int first, int last) {
		int temp;
		if(first < last) {
			int pivot = first;
			int left = first;
			int right = last;
			
			while(left < right) {
				while(arr[left] <= arr[pivot] && left < last) {
					left++;
				}
				while(arr[right] > arr[pivot]) {
					right--;
				}
				if(left < right) {
					temp = arr[left];
					arr[left] = arr[right];
					arr[right] = temp;
				}
			}
			
			temp = arr[pivot];
			arr[pivot] = arr[right];
			arr[right] = temp;
			
			quickSort(first, right - 1);
			quickSort(right + 1, last);
		}
	}
	
	static void mergeSort() {
		
	}
}
