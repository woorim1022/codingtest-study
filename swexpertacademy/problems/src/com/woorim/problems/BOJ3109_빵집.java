package com.woorim.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109_빵집 {

	static int R, C, ans = 0;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visited = new boolean[R][C];

		for (int i = 0; i < R; ++i) {
			map[i] = in.readLine().toCharArray();
		}
		makePipe();
		System.out.println(ans);
	}

	private static void makePipe() {
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			dfs(i, 0);
		}
	}

	static int[] dr = { -1, 0, 1 };

	private static boolean dfs(int r, int c) {
		if (c == C - 1) {	// 마지막 열에 왔다면 성공.. 
			ans++;
			return true;
		}
		int nr, nc = c + 1;  // 열은 바로 옆열로 이동하므로 기존 열 + 1
		for (int d = 0; d < 3; ++d) {
			nr = r + dr[d];
			// 열에 대한 체크는 불필요 ?? 기저 조건에서 체크함
			// 방문한 흔적이 있는 경우 안간다. - 파이프가 있거나 먼저 진행했던 위치에서 안되었다
			if (nr < 0 || nr >= R || visited[nr][nc] || map[nr][nc] == 'x')
				continue;

			visited[nr][nc] = true;
			if (dfs(nr, nc)) {
				return true;
			}
			
			// 뒤에나온 선택지의 방향은 현재보다 유리하지 않은 상황이다. 따라서 같은 상황이 되풀이된다.
			// 이거하면 실패했던 위치에서 다시 또 해본다. 주의...
//			visited[nr][nc] = false;  
		}
		return false;	// 세방향 모두 갈수 있는 경우 없었음
	}
}