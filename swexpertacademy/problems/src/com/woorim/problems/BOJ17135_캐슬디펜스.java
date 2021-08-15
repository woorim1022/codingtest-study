package com.woorim.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

//궁수 3명을 배치
//궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적
//적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격
//같은 적이 여러 궁수에게 공격당할 수 있다
//(r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|
//격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자.

// M개 중 3개 뽑는 조합 구하기
// 공격
// 공격받은 적 제거
// 아래로 한칸 이동
// 

public class BOJ17135_캐슬디펜스 {
	static int N, M, D;	// 격자판 행, 열, 궁수의 공격거리 제한
	static int[][] map;
	static int[][] copyMap;
	static int max = 0;
	static int[] archerPos = new int[3]; // 궁수 세명의 열 값
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader("6 5 2\r\n" + 
//				"1 0 1 0 1\r\n" + 
//				"0 1 0 1 0\r\n" + 
//				"1 1 0 0 0\r\n" + 
//				"0 0 0 1 1\r\n" + 
//				"1 1 0 1 1\r\n" + 
//				"0 0 1 0 0"));
		
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		D = Integer.parseInt(data[2]);
		map = new int[N+1][M];
		copyMap = new int[N+1][M];
		// 격자판
		for(int i = 0; i < N; i++) {
			data = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(data[j]);
			}
		}
		
		comb(0, 0);
		System.out.println(max);
	}

	private static void comb(int cnt, int start) {
		if(cnt == 3) {
			// map 복사해주기
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			int killCnt = attack();	// 모든 적이 격자판에서 제외될 때 까지 공격을 진행한다.
			max = Math.max(killCnt, max);
//			System.out.println(Arrays.toString(archerPos));
			return;
		}
		for(int i = start; i < M; i++) {
			archerPos[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	private static int attack() {
		int killCnt = 0;
//		System.out.println("궁수좌표 : "+ Arrays.toString(archerPos));
		// map의 값이 모두 0이면 종료
		while(!isEmpty()){ 
			// 궁수 세명의 공격할 적 찾기
			for(int idx = 0; idx < 3; idx++){
				int killR = -1, killC = -1;
				int pos = archerPos[idx];
//				System.out.println("pos : " + pos);
				
				// 궁수의 사정거리 안에 있는 적 중 가장 왼쪽 적 탐색 오른쪽 -> 왼쪽, 위 -> 아래쪽 으로 탐색
				int p = 0;
				for(int col = pos+(D-1); col >= pos-(D-1); col--){ // 오 -> 왼
					if(col > pos) {
						for(int row = N-1-p; row < N; row++) { // 위 -> 아래
							if(col >= 0 && col < M && row >= 0 && row < N){
								if(copyMap[row][col] != 0) { // 적이있으면
									killR = row;
									killC = col;
								}
							}	
						}
						p++;
					}
					else if(col <= pos) {
						for(int row = N-1-p; row < N; row++) { // 위 -> 아래
							if(col >= 0 && col < M && row >= 0 && row < N){
								if(copyMap[row][col] != 0) { // 적이있으면
									killR = row;
									killC = col;
								}
							}	
						}
						p--;
					}
				}
//				System.out.println(pos + "위치의 궁수가 죽일 적 R :" + killR + " C : " + killC);
				// 사정거리 안에 적이 있으면, 킬수를 증가시키고 적을 제거한다. 
				if(killR != -1 && killC != -1 && copyMap[killR][killC] != 2) {
					copyMap[killR][killC] = 2;
					killCnt++;
				}
			}
//			System.out.println("kill수 : " + killCnt);
//			System.out.println();
//			for(int i = 0 ; i < N; i++) {
//				System.out.println(Arrays.toString(copyMap[i]));
//			}
//			System.out.println("-----------");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(copyMap[i][j] == 2) copyMap[i][j] = 0;
				}
			}
			down();
		}
		
		return killCnt;
	}
	
	private static boolean isEmpty() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] != 0) return false;
			}
		}
		return true;
	}
	
	private static void down() {
		// 적들이 한칸씩 밑으로 내려옴
//		for(int i = 0 ; i < N; i++) {
//			System.out.println(Arrays.toString(copyMap[i]));
//		}
//		System.out.println("-----------");
		for(int i = N-1; i > 0; i--) {
			for(int j = 0; j < M; j++) {
				copyMap[i][j] = copyMap[i-1][j];
			}
		}
		for(int i = 0; i < M; i++) {
			copyMap[0][i] = 0;
		}
//		for(int i = 0 ; i < N; i++) {
//			System.out.println(Arrays.toString(copyMap[i]));
//		}
	}
	
	
}
