package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1764_µË∫∏¿‚ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> hs = new HashSet<>();
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			
			hs.add(s);
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine().trim();
			
			if(!hs.add(s)) {
				list.add(s);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for (String s : list) {
			System.out.println(s);
		}
	}
}
