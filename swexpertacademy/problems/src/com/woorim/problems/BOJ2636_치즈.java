package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간과 모두 녹기 한 시간 전에
//남아있는 치즈조각이 놓여 있는 칸의 개수
public class BOJ2636_치즈 {
	static class Pos{
		int row, col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R, C;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0 ; i < R; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. bfs로 푸는법
		int time = -1;
		int ret = 0;
		while(true) {
			time++;
			visit = new boolean[R][C];
			if(countC()==0) {
				break;
			}
			ret=countC();
			bfs();
			findCheese();
			
			
		}
		System.out.println(time);
		System.out.println(ret);
	}
	static private void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0,0));
		visit[0][0] = true;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = pos.row + dx[i];
				int nc = pos.col + dy[i];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(map[nr][nc] == 0 && !visit[nr][nc]) {
					visit[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}
		}

	}
	
	static private void findCheese() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(visit[i][j]) {
					for(int k = 0; k < 4; k++) {
						int nr = i + dx[k];
						int nc = j + dy[k];
						if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
						if(map[nr][nc] == 1) {
							map[nr][nc] = 0;
						}
					}
				}
			}		
		}

	}
	static int countC() {
		int ret=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==1)ret++;
			}
		}
		return ret;
	}
//	static private void dp() {
//		// TODO Auto-generated method stub
//
//	}

}
