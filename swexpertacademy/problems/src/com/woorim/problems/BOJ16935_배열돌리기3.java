package com.woorim.problems;

import java.util.Scanner;

public class BOJ16935_배열돌리기3 {
	static int N, M;
	static int[][] map, temp;
	static int R;
	static int opr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		R = sc.nextInt();
		for (int r = 0; r < N; r++) {			 
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		for(int i = 0; i < R; i++) {
			opr = sc.nextInt();
			switch(opr){
//				1번 연산은 배열을 상하 반전.
				case 1:
					temp = new int[N][M];
					for (int r = 0; r < N; r++) {	
						for(int c = 0; c < M; c++) {
							temp[r][c] = map[N-1-r][c];
						}
					}
					break;
//				2번 연산은 배열을 좌우 반전.
				case 2:
					temp = new int[N][M];
					for (int r = 0; r < N; r++) {	
						for(int c = 0; c < M; c++) {
							temp[r][c] = map[r][M-1-c];
						}
					}
					break;
//				3번 연산은 오른쪽으로 90도 회전.
				case 3:
					temp = new int[M][N];
					for (int r = 0; r < M; r++) {	
						for(int c = 0; c < N; c++) {
							temp[r][c] = map[N-c-1][r];
						}
					}
					break;
//				4번 연산은 왼쪽으로 90도 회전.
				case 4:
					temp = new int[M][N];
					for (int r = 0; r < M; r++) {	
						for(int c = 0; c < N; c++) {
							temp[r][c] = map[c][M-r-1];
						}
					}
					break;
//				5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동
				case 5:
					temp = new int[N][M];
					for (int r = 0; r < N/2; r++) {	
						for(int c = 0; c < M/2; c++) {
							temp[r][c] = map[r+N/2][c];
						}
					}
					for (int r = 0; r < N/2; r++) {	
						for(int c = M/2; c < M; c++) {
							temp[r][c] = map[r][c-M/2];
						}
					}
					for (int r = N/2; r < N; r++) {	
						for(int c = 0; c < M/2; c++) {
							temp[r][c] = map[r][c+M/2];
						}
					}
					for (int r = N/2; r < N; r++) {	
						for(int c = M/2; c < M; c++) {
							temp[r][c] = map[r-N/2][c];
						}
					}
					break;
//				6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동
				case 6:
					temp = new int[N][M];
					for (int r = 0; r < N/2; r++) {	
						for(int c = 0; c < M/2; c++) {
							temp[r][c] = map[r][c+M/2];
						}
					}
					for (int r = 0; r < N/2; r++) {	
						for(int c = M/2; c < M; c++) {
							temp[r][c] = map[r+N/2][c];
						}
					}
					for (int r = N/2; r < N; r++) {	
						for(int c = 0; c < M/2; c++) {
							temp[r][c] = map[r-N/2][c];
						}
					}
					for (int r = N/2; r < N; r++) {	
						for(int c = M/2; c < M; c++) {
							temp[r][c] = map[r][c-M/2];
						}
					}
					break;
			}
			N = temp.length;
			M = temp[0].length;
			map = new int[N][M];
			for (int r = 0; r < N; r++) {			 
				for (int c = 0; c < M; c++) {
					map[r][c] = temp[r][c];
				}
			}
		}
		
		for(int i =0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " "); 
			}
			System.out.println();	
		}
	}

}
