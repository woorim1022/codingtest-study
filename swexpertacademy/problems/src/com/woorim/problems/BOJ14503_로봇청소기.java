package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14503_로봇청소기 {
	static String str = "11 10\r\n" + 
			"7 4 0\r\n" + 
			"1 1 1 1 1 1 1 1 1 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 1 1 1 1 0 1\r\n" + 
			"1 0 0 1 1 0 0 0 0 1\r\n" + 
			"1 0 1 1 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 0 0 0 1 0 1\r\n" + 
			"1 0 0 0 0 0 1 1 0 1\r\n" + 
			"1 0 0 0 0 0 1 1 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"1 1 1 1 1 1 1 1 1 1";
	static class Pos{
		int r, c, d;
		public Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	//{북, 동, 남, 서} 왼쪽 : 인덱스값 -1
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, M;
	static Pos start;
	static int[][] map;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(str));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		start = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());;
			}
		}
//		System.out.println(Arrays.deepToString(map));
		
		solve(start.r, start.c, start.d);
		
		System.out.println(answer);
	}
	
	static public void solve(int cR, int cC, int cD) {
	    Queue<Pos> q = new LinkedList<>();
	    answer++;
	    q.offer(new Pos(cR, cC, cD));
	    while(!q.isEmpty()) {
	        Pos pos = q.poll();
	        map[pos.r][pos.c] = 2;
	        int newD = pos.d;
	        int flag = 0;
	        for(int i = 0; i < 4; i++) {
        	    newD -= 1;
 	            if (newD <0)
 	                newD = 3;
 	            // 전진
 	            int nr = pos.r + dr[newD];
 	            int nc = pos.c + dc[newD];
 	            if (map[nr][nc] == 0) {
 	            	map[nr][nc] = 2;
	                answer +=1;
	                q.offer(new Pos(nr,nc,newD));
	                flag = 1;
	                break;
 	            }
 	            	
 	                
	        }
	           
	        //청소 불가능
	        if (flag == 0) {
	        	int a = pos.r + dr[(pos.d+2)%4];
	            int b = pos.c + dc[(pos.d+2)%4];
	            if (map[a][b] == 1)
	                return;
	            else
	                q.offer(new Pos(a, b, pos.d));
	        }
	            
	    }

	}
}
