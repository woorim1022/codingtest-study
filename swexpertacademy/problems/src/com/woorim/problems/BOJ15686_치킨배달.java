package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


/*
 * 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 
 * 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.
 * 도시의 치킨 거리의 최솟값을 출력한다.
 * **/

/*
 * 메모이제이션으로 집의 크기를 정해서 참조
 * **/


public class BOJ15686_치킨배달 {
	static class Loc{
		int x, y;
		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	// 좌표를 표현하기 위해 클래스를 만들거나 int 형 배열을 제네릭으로 넣는다.
	static ArrayList<Loc> home = new ArrayList<>();
	static ArrayList<Loc> chickens = new ArrayList<>();
	static int N, M, ans = (int)1e9; // 1e9 : 10억, 최소값이 정답이므로 최대값으로 초기화
	static int[] numbers;
	static int[][] dist;	// 치킨집과 집과의 거리를 저장할 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader("5 3\r\n" + 
//				"0 0 1 0 0\r\n" + 
//				"0 0 2 0 1\r\n" + 
//				"0 1 2 0 0\r\n" + 
//				"0 0 1 0 0\r\n" + 
//				"0 0 0 0 2"));
		
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		for(int i = 0; i < N; i++) {
			data = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int val = Integer.parseInt(data[j]);
				if(val == 1) {
					home.add(new Loc(i, j));// 집
				}
				else if(val == 2) {
					chickens.add(new Loc(i, j));// 치킨집
				}
			}
		}
		
		// 치킨집과 집의 거리를 저장하자. - 메모이제이션
		dist = new int[13][100];
		for(int i = 0; i < chickens.size(); i++) {
			for(int j = 0; j < home.size(); j++) {
				dist[i][j] = calcDist(chickens.get(i), home.get(j));
			}
		}
		
		// 조합처리
		numbers = new int[M];
		comb(0,0);
		System.out.println(ans);
	}
	static void comb(int cnt, int start) {
		if(cnt == M) {
			// 도시의 치킨거리를 구한다.
			int cityDist = 0;
			for(int i = 0; i < home.size(); i++) {
				int homeDist = (int)1e9;
				for(int j = 0; j < M; j++) {
					homeDist = Math.min(homeDist, dist[numbers[j]][i]); // 집의 치킨거리
				}
				cityDist += homeDist;
			}
			// 모든 조합의 치킨거리에서 가장 작은 치킨거리를 구한다.
			ans = Math.min(ans, cityDist);
			return;
		}
		for(int i = start; i < chickens.size(); i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
	private static int calcDist(Loc chickens, Loc home) {
		return Math.abs(chickens.x - home.x) + Math.abs(chickens.y - home.y);

	}

}

























