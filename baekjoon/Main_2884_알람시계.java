package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2884_알람시계 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		M -= 45;
		if(M < 0) {
			H--;
			M += 60;
		}
		
		if(H < 0) {
			H += 24;
		}
		
		System.out.println(H + " " + M);
	}
}
