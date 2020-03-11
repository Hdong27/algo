package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1234_비밀번호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			
			String s = st.nextToken();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(s.charAt(i) - '0');
			}
			
			for (int i = 0; i < list.size() - 1;) {
				if(list.get(i) == list.get(i + 1)) {
					list.remove(i);
					list.remove(i);
					i = i == 0 ? 0 : i - 1;
				} else {
					i++;
				}
			}
			
			System.out.print("#" + t + " ");
			for (Integer temp : list) {
				System.out.print(temp);
			}
			System.out.println();
		}
	}
}
