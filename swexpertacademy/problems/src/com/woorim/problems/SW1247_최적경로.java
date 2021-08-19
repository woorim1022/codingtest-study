package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산된다.
//회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것
//회사와 집의 좌표가 주어지고, 2명에서 10명 사이의 고객 좌표가 주어질 때,
//회사에서 출발해서 이들을 모두 방문하고 집에 돌아가는 경로 중 
//총 이동거리가 가장 짧은 경로를 찾는 프로그램을 작성하라.
public class SW1247_최적경로 {
	static int N;
	static int[] companyPos, homePos;
	static int[][] consumerPos;
	static boolean[] visit;
	static int[] distance;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			companyPos = new int[2];
			homePos = new int[2];
			consumerPos = new int[N][2];
			visit = new boolean[N];
			distance = new int[N+2];
			companyPos[0] = Integer.parseInt(st.nextToken());
			companyPos[1] = Integer.parseInt(st.nextToken());
			homePos[0] = Integer.parseInt(st.nextToken());
			homePos[1] = Integer.parseInt(st.nextToken());
			for(int i = 0; i < N; i++) {
				consumerPos[i][0] = Integer.parseInt(st.nextToken());
				consumerPos[i][1] = Integer.parseInt(st.nextToken());				
			}
//			System.out.println(Arrays.toString(companyPos));
//			System.out.println(Arrays.toString(homePos));
//			System.out.println(Arrays.deepToString(consumerPos));
			solve(companyPos, 0);
			
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void solve(int[] curPos, int cnt) {
		if(cnt == N) {
			distance[cnt] = Math.abs(curPos[0]-homePos[0]) + Math.abs(curPos[1]-homePos[1]); 
			int sum = 0;
			for(int i = 0; i <= N+1; i++) {
				sum += distance[i];
			}
			ans = Math.min(ans, sum);
		}
		for(int i = 0; i < N; i++) {
			if(visit[i] == true) continue;
			else {
				visit[i] = true;
				distance[cnt] = Math.abs(curPos[0]-consumerPos[i][0]) + Math.abs(curPos[1]-consumerPos[i][1]);
//				System.out.println("distance[cnt]" + distance[cnt]);
				solve(consumerPos[i], cnt+1);
				visit[i] = false;
			}
		}

	}
	

}
