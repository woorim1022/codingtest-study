package com.woorim.problems;
//처음에 아기 상어의 크기는 2이고, 
//아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
//자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고,
//나머지 칸은 모두 지나갈 수 있다.
//자신의 크기보다 작은 물고기만 먹을 수 있다. 
//크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
/*
 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 
지나야하는 칸의 개수의 최솟값이다.
거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 
가장 왼쪽에 있는 물고기를 먹는다.
 */
//자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 
//예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
//0: 빈 칸
//1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
//9: 아기 상어의 위치
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ16236_아기상어 {
	static class Pos{
		int r, c, moveCnt;
		public Pos(int r, int c, int moveCnt) {
			this.r = r;
			this.c = c;
			this.moveCnt = moveCnt;
		}
	}
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int N;	// 맵의 크기
	static int[][] map;
	static int[] shark; // 상어정보, 먹을 물고기 정보
	static boolean[][] visit;
	static int eatCnt;
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new int[] {i, j, 2};// 행, 열, 크기
				}
			}
		}
		
		//1. 자신과 가장 가깝고 자기보다 작은 물고기를 bfs로 탐색(아기상어보다 크면 탐색 X)
		//		거리 이동할 때 마다 cnt 증가
		//		0보다 크고 아기 상어보다 작으면 잡아먹어, eatCnt++
		//    	if(eatCnt == 상어크기 )	상어크기++
		eatCnt = 0;

		map[shark[0]][shark[1]] = 0;
		boolean possible = solve(shark[0], shark[1]);
		while(possible) {
			visit = new boolean[N][N];
			possible = solve(shark[0], shark[1]);
		}
		
		
		System.out.println(ans);

	}
	private static boolean solve(int curR, int curC) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(curR, curC, 1));
		visit[curR][curC] = true;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dx[i];
				int nc = pos.c + dy[i];
				int moveCnt = pos.moveCnt;
				//System.out.println("moveCnt : " + moveCnt);
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] > shark[2]) continue;
				if(!visit[nr][nc]) {
					visit[nr][nc] = true;
					if(map[nr][nc] > 0 && map[nr][nc] < shark[2] ){
						// 먹을 수 있는 물고기인 경우
						//가장 가까운 물고기, 가장 위, 가장 왼쪽
						// 먹어 
						shark[0] = nr;
						shark[1] = nc;
						eatCnt++;
						ans += moveCnt;
						//System.out.println("ans : " + ans);
						map[nr][nc] = 0;
						if(shark[2] == eatCnt) {
							shark[2]++;
							eatCnt = 0;
						}
						return true;
					}
					q.offer(new Pos(nr, nc, ++moveCnt));
				}
			}
		}
		return false;
	}

}
