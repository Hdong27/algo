package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_·Î¶Ç {
	static int N;
	static int[] save;
	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0) break;

			num = new int[N];
			
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			save = new int[6];
			
			Comb(0, 0);
			System.out.println();
		}
	}
	
	static void Comb(int cnt, int start) {
		if(cnt == 6) {
			Arrays.sort(save);
			for (int i = 0; i < 6; i++) {
				System.out.print(save[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < N; i++) {
			save[cnt] = num[i];
			Comb(cnt+1, i+1);
		}
	}
}
