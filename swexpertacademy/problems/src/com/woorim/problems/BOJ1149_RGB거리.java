package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다
//모든 집을 칠하는 비용의 최솟값을 구해보자.

// 만족해야 할 규칙
//1번 집의 색은 2번 집의 색과 같지 않아야 한다.
//N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
//i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
public class BOJ1149_RGB거리 {
	static int N;	// 집의 수
	static int[][] price; //각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터
	static int answer;
	static int[][] DP;
	static final int Red = 0;
	static final int Green = 1;
	static final int Blue = 2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		price = new int[N][3];
		DP = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			price[i][0] = Integer.parseInt(st.nextToken());
			price[i][1] = Integer.parseInt(st.nextToken());
			price[i][2] = Integer.parseInt(st.nextToken());
		}
		// DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
		DP[0][Red] = price[0][Red];	
		DP[0][Green] = price[0][Green];
		DP[0][Blue] = price[0][Blue];
		
		
		System.out.print(Math.min(solve(N- 1, Red), Math.min(solve(N - 1, Green), solve(N - 1, Blue))));

	}
	static private int solve(int N, int color) {
		// 만약 탐색하지 않은 배열이라면
		if(DP[N][color] == 0) {

			// color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
			if(color == Red) {
				DP[N][Red] = Math.min(solve(N - 1, Green), solve(N - 1, Blue)) + price[N][Red];
			}
			else if(color == Green) {
				DP[N][Green] = Math.min(solve(N - 1, Red), solve(N - 1, Blue)) + price[N][Green];
			}
			else {
				DP[N][Blue] = Math.min(solve(N - 1, Red), solve(N - 1, Green)) + price[N][Blue];
			}
			
			
		}
		return DP[N][color];
	}
}
