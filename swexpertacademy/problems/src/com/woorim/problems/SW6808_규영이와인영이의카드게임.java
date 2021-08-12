package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 순열과 조합
 * */
//높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,
//낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.

public class SW6808_규영이와인영이의카드게임 {
	public static int[] gyoung;
	public static int[] card = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
	public static int gScore, iScore;
	public static int win, loose;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			gyoung = new int[9];
			int flag = 0;
			gScore = 0; iScore = 0;
			win = 0; loose = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				gyoung[i] = Integer.parseInt(st.nextToken());
				flag = flag | 1<<gyoung[i]-1;
			}
			// gyoung = [1 3 5 7 9 11 13 15 17]
			
			permutation(0, flag, gScore, iScore);
			
			System.out.println("#" + t + " " + win + " " + loose);
		}
	}
	
	
	private static void permutation(int cnt, int flag, int gScore, int iScore) {
		if(cnt == 9) {
			if(gScore > iScore) win++;
			else if(gScore < iScore) loose++;
			return;
		}
		for(int i = 0; i < 18; i++) {
			// card = [1 3 5 7 9 11 13 15 17]
			// gyoung[cnt] 내가 이번판에 낸 카드
			if((flag & 1<<i) != 0) continue;
			else {
				if(card[i] < gyoung[cnt]) gScore += card[i] + gyoung[cnt];
				else iScore += card[i] + gyoung[cnt];
				
				permutation(cnt+1, flag | 1<<i, gScore, iScore);
				
				if(card[i] < gyoung[cnt]) gScore -= card[i] + gyoung[cnt];
				else iScore -= card[i] + gyoung[cnt];
			}
		}
	}
}
