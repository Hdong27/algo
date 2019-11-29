package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1991_트리순회 {
	static char[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		arr = new char[(int)Math.pow(2, N)];
		Arrays.fill(arr, '.');
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		char root = st.nextToken().charAt(0);
		arr[1] = root;
		hm.put(root, 1);
		char child1 = st.nextToken().charAt(0);
		arr[2] = child1;
		hm.put(child1, 2);
		char child2 = st.nextToken().charAt(0);
		arr[3] = child2;
		hm.put(child2, 3);
		
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			root = st.nextToken().charAt(0);
			child1 = st.nextToken().charAt(0);
			child2 = st.nextToken().charAt(0);
			
			int index = hm.get(root);
			arr[index * 2] = child1;
			hm.put(child1, index * 2);
			arr[index * 2 + 1] = child2;
			hm.put(child2, index * 2 + 1);
		}
		
		System.out.println(Arrays.toString(arr));
		
		
	}
	
	// 전위순회
	static void front(int index) {
		if(arr[index] == '.') {
			
		} else {
			System.out.print(arr[index]);
		}
		front(index * 2);
	}
}
