package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_10707_수도요금 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine().trim());
		int B = Integer.parseInt(br.readLine().trim());
		int C = Integer.parseInt(br.readLine().trim());
		int D = Integer.parseInt(br.readLine().trim());
		int P = Integer.parseInt(br.readLine().trim());
		
		A *= P;
		
		if(P > C) {
			B += (P - C) * D;
		}
		
		System.out.println(A < B ? A : B);
	}
}
