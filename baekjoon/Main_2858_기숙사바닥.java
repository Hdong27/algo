package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2858_±â¼÷»ç¹Ù´Ú {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
loop:	for (int i = 1; i <= B; i++) {
			for (int j = 1; j <= B; j++) {
				if(i * j == B) {
					// Å¸ÀÏÀÇ °¹¼ö°¡ ¸ÂÀ¸¸é
					if(((i + 2) + (j + 2)) * 2 - 4 == R) {
						System.out.println(Math.max(i + 2, j + 2) + " " + Math.min(i + 2, j + 2));
						break loop;
					}
				}
			}
		}
	}
}
