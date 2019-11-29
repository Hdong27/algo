package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1181_단어정렬 {
	static String[] arr;
	static String[] arr2;
	// MergeSort
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		
		arr = new String[N];
		arr2 = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().trim();
		}
		
		partition(0, N - 1);
		
		for (int i = 0; i < N; i++) {
			if(i > 0 && arr[i].equals(arr[i-1])) continue;
			bw.append(arr[i] + "\n");
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
			if(compare(arr[l], arr[r])) {
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
	
	static boolean compare(String a, String b) {
		if(a.length() < b.length()) {
			return true;
		} else if(a.length() > b.length()) {
			return false;
		} else {	// ==
			int i = 0;
			for (i = 0; i < a.length() && i < b.length(); i++) {
				if(a.charAt(i) < b.charAt(i)) {
					return true;
				} else if(a.charAt(i) > b.charAt(i)) {
					return false;
				}
			}
			return true;
		}
	}
	
	/*
	 QuickSort
	private static String[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		
//		arr = new String[N];
//		for (int i = 0; i < N; i++) {
//			arr[i] = br.readLine().trim();
//		}
//		
//		quickSort(0, N - 1);
		
		Ob[] arr2 = new Ob[N];
		for (int i = 0; i < N; i++) {
			arr2[i] = new Ob(br.readLine().trim());
		}
		
		Arrays.sort(arr2);
		
		for (int i = 0; i < N; i++) {
			if(i > 0 && arr2[i].s.equals(arr2[i-1].s)) continue;
			bw.append(arr2[i].s + "\n");
		}
		bw.flush();
	}
	
	static class Ob implements Comparable<Ob>{
		String s;
		
		public Ob(String s) {
			this.s = s;
		}

		@Override
		public int compareTo(Ob o) {
			if(this.s.length() == o.s.length()) {
				for (int i = 0; i < this.s.length(); i++) {
					if(this.s.charAt(i) != o.s.charAt(i)) {
						return this.s.charAt(i) - o.s.charAt(i);
					}
				}
			}
			return this.s.length() - o.s.length();
		}
	}
	
	static void quickSort(int left, int right) {
		String temp;
		if(left < right) {
			int pivot = left;
			int l = left;
			int r = right;
			
			while(l < r) {
				while(compare1(arr[l], arr[pivot]) && l < right) {
					l++;
				}
				while(compare2(arr[pivot], arr[r])) {
					r--;
				}
				if(l < r) {
					temp = arr[r];
					arr[r] = arr[l];
					arr[l] = temp;
				}
			}
			temp = arr[pivot];
			arr[pivot] = arr[r];
			arr[r] = temp;
			quickSort(left, r - 1);
			quickSort(r + 1, right);
		}
	}
	
	// a가 작으면 true, b가 작으면 false
	static boolean compare1(String a, String b) {
		if(a.length() < b.length()) {
			return true;
		} else if(a.length() > b.length()) {
			return false;
		} else {	// ==
			int i = 0;
			for (i = 0; i < a.length() && i < b.length(); i++) {
				if(a.charAt(i) < b.charAt(i)) {
					return true;
				} else if(a.charAt(i) > b.charAt(i)) {
					return false;
				}
			}
			return true;
		}
	}
	
	// a가 작으면 true, b가 작으면 false
	static boolean compare2(String a, String b) {
		if(a.length() < b.length()) {
			return true;
		} else if(a.length() > b.length()) {
			return false;
		} else {	// ==
			int i = 0;
			for (i = 0; i < a.length() && i < b.length(); i++) {
				if(a.charAt(i) < b.charAt(i)) {
					return true;
				} else if(a.charAt(i) > b.charAt(i)) {
					return false;
				}
			}
			return false;
		}
	}
	*/
}
