package com.woorim.problems;

//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 
//것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//
//입력
//첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
//다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
//4 5 1
//1 2
//1 3
//1 4
//2 4
//3 4
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ1260_dfs와bfs {
	static int N, M, V;
	static int[][] tree;
	static boolean[] v;
	static ArrayList<Integer> dfs;
	static ArrayList<Integer> bfs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader("5 5 3\r\n" + 
//				"5 4\r\n" + 
//				"5 2\r\n" + 
//				"1 2\r\n" + 
//				"3 4\r\n" + 
//				"3 1"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		dfs = new ArrayList<>();
		bfs = new ArrayList<>();
		tree = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			tree[n1][n2] = 1;
			tree[n2][n1] = 1;
		}
		
		v = new boolean[N+1];
		dfs(V, 0);
		v = new boolean[N+1];
		bfs();
		
		for(int i = 0; i < dfs.size(); i++) {
			System.out.print(dfs.get(i) + " ");
		}
		System.out.println();
		for(int i = 0; i < bfs.size(); i++) {
			System.out.print(bfs.get(i) + " ");
		}
		
	}
	
	private static void bfs() {
		// 너비우선탐색
		// 루트노드를 큐에 삽입한다
		// 큐에서 루트노드를 꺼내고 루트노드의 자식노드에 순서대로 방문한다. 방문한 노드를 큐에 삽입한다.
		// 루트노드의 자식노드를 모두 방문했으면 자식노드를 큐에서 하나씩 꺼내 동일한 방법으로 다시 자식노드에 방문한다.
		Queue<Integer> q = new LinkedList<>();
		q.offer(V);
		v[V] = true;
		bfs.add(V);
		int node;
		while(!q.isEmpty()) {
			node = q.poll();
			for(int i = 1; i < N+1; i++) {
				if(tree[node][i] == 1 && v[i] == false) {
					v[i] = true;
					bfs.add(i);
					q.offer(i);
				}
			}
		}
	}
	
	private static void dfs(int node, int cnt) {
		// 깊이우선탐색
		// 루트노드에 방문한다
		// 루트노드의 자식노드, 다시 그 자식노드에 방문하며 더 이상 자식이 없을 때까지 재귀적으로 방문한다.
		// 더 이상 방문할 자식이 없으면 재귀문을 벗어나 부모노드로 돌아와서 다음 자식 노드를 방문한다.
		dfs.add(node);
		v[node] = true;
		if(cnt == N) {
			return;
		}
		for(int i = 1; i < N+1; i++) {	
			if(tree[node][i] == 1 && v[i] == false) {
				v[i] = true;
				dfs(i, cnt+1);
			}
		}
	}

}
