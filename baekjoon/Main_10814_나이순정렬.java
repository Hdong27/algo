package baekjoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10814_나이순정렬 {
	private static User[] arr;
	private static User[] arr2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		arr = new User[N];
		arr2 = new User[N];
		
		int index = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new User(index++, Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		partition(0, N - 1);
		
		for (int i = 0; i < N; i++) {
			bw.append(arr[i].age + " " + arr[i].name + "\n");
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
			if(arr[l].age < arr[r].age) {
				arr2[i++] = arr[l++];
			} else if(arr[l].age > arr[r].age) {
				arr2[i++] = arr[r++];
			} else {
				if(arr[l].index < arr[r].index) {
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
	
	static class User {
		int index;
		int age;
		String name;
		
		public User(int index, int age, String name) {
			this.index = index;
			this.age = age;
			this.name = name;
		}
	}
}
