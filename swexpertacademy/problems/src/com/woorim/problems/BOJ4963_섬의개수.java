package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963_섬의개수 {
	static class Pos{
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, -1, 0, 1, -1};
	static int h, w;
	static int map[][];
	static boolean visited[][];
	static int cnt;
	static ArrayList<Integer> ans = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while(true){
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			map = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;
			for (int t = 0; t < h; t++) {
				st = new StringTokenizer(br.readLine());
				int ans = 0;
				for(int i = 0; i < w; i++) {
					map[t][i] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			ans.add(cnt);
		}
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}

	}
	private static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r, c));
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for(int i = 0; i < 8; i++) {
				int nr = cur.r + dx[i];
				int nc = cur.c + dy[i];
				if(nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
				if(map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc));
					continue;
				}
			}
		}

	}

}
