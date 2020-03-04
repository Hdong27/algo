package swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1221_GNS {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String testCase = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] num = new int[10];
			
			for (int i = 0; i < N; i++) {
				String temp = st.nextToken();
				
				if(temp.charAt(0) == 'Z') {
					num[0]++;
				} else if(temp.charAt(0) == 'O') {
					num[1]++;
				} else if(temp.charAt(0) == 'T') {
					if(temp.charAt(1) == 'W') {
						num[2]++;
					} else {
						num[3]++;
					}
				} else if(temp.charAt(0) == 'F') {
					if(temp.charAt(1) == 'O') {
						num[4]++;
					} else {
						num[5]++;
					}
				} else if(temp.charAt(0) == 'S') {
					if(temp.charAt(1) == 'I') {
						num[6]++;
					} else {
						num[7]++;
					}
				} else if(temp.charAt(0) == 'E') {
					num[8]++;
				} else if(temp.charAt(0) == 'N') {
					num[9]++;
				}
			}
			
			bw.append(testCase + "\n");
			while(num[0] > 0) {
				bw.append("ZRO ");
				num[0]--;
			}
			while(num[1] > 0) {
				bw.append("ONE ");
				num[1]--;
			}
			while(num[2] > 0) {
				bw.append("TWO ");
				num[2]--;
			}
			while(num[3] > 0) {
				bw.append("THR ");
				num[3]--;
			}
			while(num[4] > 0) {
				bw.append("FOR ");
				num[4]--;
			}
			while(num[5] > 0) {
				bw.append("FIV ");
				num[5]--;
			}
			while(num[6] > 0) {
				bw.append("SIX ");
				num[6]--;
			}
			while(num[7] > 0) {
				bw.append("SVN ");
				num[7]--;
			}
			while(num[8] > 0) {
				bw.append("EGT ");
				num[8]--;
			}
			while(num[9] > 0) {
				bw.append("NIN ");
				num[9]--;
			}
			bw.append("\n");
		}
		
		bw.flush();
	}
}
