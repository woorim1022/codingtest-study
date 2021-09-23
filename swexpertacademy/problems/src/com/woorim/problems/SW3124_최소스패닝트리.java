package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW3124_최소스패닝트리 {
	static class Edge implements Comparable<Edge>{
		int start, end, weight;
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static Edge[] list;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new Edge[E];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list[i] = new Edge(start, end, weight);
			}
			Arrays.sort(list);
			
			make();
			
			int cnt = 0;
			long result = 0;
			for (Edge edge : list) {
				if (union(edge.start, edge.end)) {
					result += edge.weight;
					cnt++;
					if (cnt == V-1) break;
				}
			}

			System.out.println("#" + t + " " + result);
		}

	}

	private static void make() {
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}


}
