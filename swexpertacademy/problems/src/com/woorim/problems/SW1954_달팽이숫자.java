package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1954_달팽이숫자 {

	public static void main(String[] args) throws Exception  {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int T = Integer.parseInt(br.readLine());
//		 System.out.println(N);
		 for(int t=1; t<=T; t++) {
			 int N = Integer.parseInt(br.readLine());
			 int[][] map = new int[N][N];
			 int snail = 1;
			 int x = 0, y = 0;
			 int dir = 1;
			 int n = N-1;

			 for (int i = 0; i < N; i++) { 
				 	map[0][i] = snail++;
					y = i;
			}

			while(snail <= N * N) {
				for (int i = 0; i < n; i++) { 
					x = x+dir;
					map[x][y] = snail++;
				}
				for (int j = 0; j < n; j++) { 
					y = y-dir;
					map[x][y] = snail++;
				}
				dir *= -1;                 
				n -= 1;                        

			}
			 
			System.out.println("#" + t);
			for (int i = 0; i < map.length; i++) {
				for (int b = 0; b < map[i].length; b++) {
					System.out.print(map[i][b] + " ");
				}
				System.out.println();
			}

		 }
	}

}
