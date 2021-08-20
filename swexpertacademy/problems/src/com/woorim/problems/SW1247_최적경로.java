package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;

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





//
//
//public class Solution_1247_최적경로1 {
//
//	static int homeX, homeY, comX, comY;
//	static int[][] customers;
//	static boolean[] v;
//	static int[] sel;
//	static int N, ans, min;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for (int t = 1; t <= T; t++) {
//			N = sc.nextInt();
//
//			v = new boolean[N];
//			sel = new int[N];
//
//			comX = sc.nextInt();
//			comY = sc.nextInt();
//
//			homeX = sc.nextInt();
//			homeY = sc.nextInt();
//
//			customers = new int[N][2];
//
//			for (int i = 0; i < N; i++) {
//				customers[i][0] = sc.nextInt();
//				customers[i][1] = sc.nextInt();
//			}
//
//			min = Integer.MAX_VALUE;
//
//			dfs(0);
//
//			System.out.println("#" + t + " " + min);
//		}
//		sc.close();
//	}
//
//	static int distance(int x1, int y1, int x2, int y2) {
//		return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
//	}
//
//	static void dfs(int cnt) {
//		if (cnt == N) {
//			int sum = 0;
//			sum += distance(customers[sel[0]][0], customers[sel[0]][1], comX, comY);
//			for (int i = 0; i < N - 1; i++) {
//				sum += distance(customers[sel[i]][0], customers[sel[i]][1], customers[sel[i + 1]][0],
//						customers[sel[i + 1]][1]);
//			}
//			sum += distance(customers[sel[N - 1]][0], customers[sel[N - 1]][1], homeX, homeY);
//			
//			min = Math.min(min, sum);
//			return;
//		}
//
//		for (int i = 0; i < N; i++) {
//			if (v[i]) continue;
//			
//			v[i] = true;
//			sel[cnt] = i;
//			dfs(cnt + 1);
//			v[i] = false;
//		}
//	}
//}




/**
 * 집의 각 거리를 메모리에 저장하고 재사용
 */
//
//public class Solution_1247_최적경로2 {
//
//	static int[][] data, D;
//	static boolean[] v;
//	static int[] sel;
//	static int N, ans;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for (int t = 1; t <= T; t++) {
//			N = sc.nextInt();
//
//			// 선택되어지는 인덱스가 1부터 시작해야 한다.(0번째를 회사 사용하므로)
//			v = new boolean[N + 1];
//			sel = new int[N];
//			
//			// 회사와 집을 추가해서 처리 : N + 2가 됨
//			data = new int[N + 2][2];
//			
//			// 회사
//			data[0][0] = sc.nextInt();
//			data[0][1] = sc.nextInt();
//			
//			// 집
//			data[N + 1][0] = sc.nextInt();
//			data[N + 1][1] = sc.nextInt();
//
//			// 
//			for (int i = 1; i <= N; i++) {
//				data[i][0] = sc.nextInt();
//				data[i][1] = sc.nextInt();
//			}
//
//			D = new int[N + 2][N + 2];	
//			for (int i = 0; i < N + 1; i++)
//				for (int j = i + 1; j < N + 2; j++)
//					D[i][j] = D[j][i] = distance(data[i][0], data[i][1], data[j][0], data[j][1]);
//
//			ans = Integer.MAX_VALUE;
//			dfs(0);
//			System.out.println("#" + t + " " + ans);
//		}
//		sc.close();
//	}
//
//	static int distance(int x1, int y1, int x2, int y2) {
//		return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
//	}
//
//	static void dfs(int cnt) {
//		
//		if (cnt == N) {
//			int sum = D[0][sel[0]];
//			for (int i = 0; i < N - 1; i++) {
//				sum += D[sel[i]][sel[i + 1]];
//			}
//			sum += D[sel[N - 1]][N + 1];
//			ans = Math.min(ans, sum);
//			return;
//		}
//
//		// 위치를 1부터 시작하게 한다.(0번째는 회사이므로..)
//		for (int i = 1; i <= N; i++) {
//			if (v[i]) continue;
//			
//			v[i] = true;
//			sel[cnt] = i;
//			dfs(cnt + 1);
//			v[i] = false;
//		}
//	}
//}


/**
 * 집의 각 거리를 메모리에 저장하고 재사용
 * 
 * 가지치기 추가
 */
//
//public class Solution_1247_최적경로3 {
//
//	static int[][] data, D;
//	static boolean[] v;
//	static int[] sel;
//	static int N, ans;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for (int t = 1; t <= T; t++) {
//			N = sc.nextInt();
//
//			// 선택되어지는 인덱스가 1부터 시작해야 한다.(0번째를 회사 사용하므로)
//			v = new boolean[N + 1];
//			sel = new int[N];
//			
//			// 회사와 집을 추가해서 처리 : N + 2가 됨
//			data = new int[N + 2][2];
//			
//			// 회사
//			data[0][0] = sc.nextInt();
//			data[0][1] = sc.nextInt();
//			
//			// 집
//			data[N + 1][0] = sc.nextInt();
//			data[N + 1][1] = sc.nextInt();
//
//			// 
//			for (int i = 1; i <= N; i++) {
//				data[i][0] = sc.nextInt();
//				data[i][1] = sc.nextInt();
//			}
//
//			D = new int[N + 2][N + 2];	
//			for (int i = 0; i < N + 1; i++)
//				for (int j = i + 1; j < N + 2; j++)
//					D[i][j] = D[j][i] = 
//							Math.abs(data[i][0] - data[j][0]) + Math.abs(data[i][1] - data[j][1]);
//			
//			ans = Integer.MAX_VALUE;
//			
//			dfs(0, 0);	// 위치, 합계
//			System.out.println("#" + t + " " + ans);
//		}
//		sc.close();
//	}
//
//	static void dfs(int cnt, int sum) {
//		if (cnt == N) {
//			sum += D[sel[N - 1]][N + 1];
//			ans = Math.min(ans, sum);
//			return;
//		}
//
//		// 위치를 1부터 시작하게 한다.(0번째는 회사이므로..)
//		for (int i = 1; i <= N; i++) {
//			if (v[i]) continue;
//			
//			v[i] = true;
//			sel[cnt] = i;
//			
//			int pos = (cnt == 0) ? 0 : sel[cnt - 1];
//			if (sum + D[pos][sel[cnt]] < ans) {
//				dfs(cnt + 1, sum + D[pos][sel[cnt]]);
//			}
//			
//			v[i] = false;
//		}
//	}
//}