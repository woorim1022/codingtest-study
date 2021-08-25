package com.woorim.problems;
//그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 
//구역의 수를 구하는 프로그램
//N×N
/*
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10026_적록색약 {
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static char[][] map;
	static int N;
	static int cnt;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int colorBlind, normal;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					solve(i, j);
				}
			}
		}
		normal = cnt;
		cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					solve(i, j);
				}
			}
		}
		colorBlind = cnt;
		System.out.println(normal + " " + colorBlind);
	}
	private static void solve(int row, int col) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(row, col));
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for (int i = 0; i < 4; i++) { 
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(!visited[nx][ny] && (map[nx][ny]==map[pos.x][pos.y]) ) {
					visited[nx][ny] = true;
					q.offer(new Pos(nx, ny));
				}
			}
		}
		cnt++;
	}
}
