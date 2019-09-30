package swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int xminus = Math.abs(x2 - x1);
			int yminus = Math.abs(y2 - y1);
			
			int max = Math.max(xminus, yminus);
			
			if(Math.abs(xminus - yminus) % 2 == 1) {
				bw.write("#" + t + " " + (max + max - 1) + "\n");
			} else {
				bw.write("#" + t + " " + (max + max) + "\n");
			}
			
		}
		bw.flush();
	}
}
