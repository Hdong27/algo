package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1230_¾ÏÈ£¹®3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			List<String> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine().trim());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				String temp = st.nextToken();
				
				if(temp.charAt(0) == 'I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = x; j < x + y; j++) {
						list.add(j, st.nextToken());
					}
				} else if(temp.charAt(0) == 'D'){
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
				} else {
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(st.nextToken());
					}
				}
			}
			
			System.out.print("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}
}
