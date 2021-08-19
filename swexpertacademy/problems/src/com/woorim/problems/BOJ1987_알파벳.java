package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오.
*/
public class BOJ1987_알파벳 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R, C;
	static int max;
	static char[][] map;
	static ArrayList<Character> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		map = new char[R][C];
		list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		list.add(map[0][0]);
		solve(0, 0, 1);
		System.out.println(max);
	}
	private static void solve(int row, int col, int cnt) {
		for(int i = 0; i < 4; i++) {
			boolean isPossible = true;
			int nr = row + dx[i];
			int nc = col + dy[i];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j) == map[nr][nc]) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) {
				list.add(map[nr][nc]);
				solve(nr, nc, cnt+1);
				list.remove(list.size() - 1);
			}
		}
		max = Math.max(max, cnt);
		return;
	}

}
