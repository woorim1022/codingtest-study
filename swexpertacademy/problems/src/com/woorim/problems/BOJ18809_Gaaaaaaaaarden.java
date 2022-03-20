package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//초록색 배양액과 빨간색 배양액이 동일한 시간에 도달한 땅에서는 
//두 배양액이 합쳐져서 꽃이 피어난다. 꽃이 피어난 땅에서는 배양액이 사라지기 때문에 
//더 이상 인접한 땅으로 배양액을 퍼트리지 않는다.
//정원과 두 배양액의 개수가 주어져있을 때 피울 수 있는 꽃의 최대 개수

// 0은 호수, 1은 배양액을 뿌릴 수 없는 땅, 2는 배양액을 뿌릴 수 있는 땅

public class BOJ18809_Gaaaaaaaaarden {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int N, M, G, R, answer, flowerCnt;
	static int[][] map;
	static int[][] temp;
	static int[] visit;
	static ArrayList<Pos> nutritionPos;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		nutritionPos = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					nutritionPos.add(new Pos(i, j, 0));
				}
			}
		}
		
		
		visit = new int[nutritionPos.size()];
		chooseGreen(G, 0);
		System.out.print(answer);
	}

	public static void chooseGreen(int g, int start) {
		//조합을 사용해서 초록색 배양액을 뿌릴 땅을 고른다
		if(g == 0) {
			chooseRed(R, 0);
			return;
		}
		for(int i = start; i < nutritionPos.size(); i++) {
			if(visit[i] == 0) {
				visit[i] = 3;
				chooseGreen(g-1, i);
				visit[i] = 0;
			}
		}
	}
	public static void chooseRed(int r, int start) {
		//초록색 땅을 다 고른 후에 남은 땅으로 조합을 사용해서 빨간색 배양액을 뿌릴 땅을 고른다
		if(r == 0) {
			nutrition();
			return;
		}
		for(int i = start; i < nutritionPos.size(); i++) {
			if(visit[i] == 0) {
				visit[i] = 4;
				chooseRed(r-1, i);
				visit[i] = 0;
			}
		}
	}
	public static void nutrition() {
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, map[i].length);
		}
		//배양액을 map에 심는다
		for (int i = 0; i < visit.length; i++) {
			Pos pos = nutritionPos.get(i);
			if(visit[i] == 3) { //초록이면
				pos.color = 3;
				temp[pos.r][pos.c] = 3;
			}else if(visit[i] == 4) { //빨강이면
				pos.color = 4;
				temp[pos.r][pos.c] = 4;
			}
		}
		spread();
	}
	
	public static void spread(){
		
		
		answer = Math.max(answer, flowerCnt);
	}
	
	public static class Pos{
		int r, c, color;
		public Pos(int r, int c, int color) {
			this.r = r;
			this.c = c;
			this.color = color;
		}
	}
}
