package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//priorityQueue는 먼저 들어온 순서대로 데이터가 나가는 것이 아닌 우선순위를 먼저 결정하고 그 
//우선순위가 높은 엘리먼트가 먼저 나가는 자료구조입니다. 우선순위 큐는 힙을 이용하여 구현하는 것이 일반적

//노선별 역을 담을 리스트와 역별로 자신을 지나가는 노선을 담을 리스트 두개를 만들어주었다.
public class BOJ2021_최소환승경로 {
	static int N, L;
	static boolean[] visitedLine;
    static boolean[] visitedStation;
    static ArrayList<Integer>[] stations;
    static ArrayList<Integer>[] lines;
    static int answer;
	static int start, end;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
 
		stations = new ArrayList[N+1];
		lines = new ArrayList[N+1];
		visitedStation = new boolean[N+1];
		visitedLine = new boolean[L+1];
		for(int i = 0; i < N+1; i++) {
			stations[i] = new ArrayList<>();
			lines[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < L ; i++) {
			String[] s = br.readLine().split(" ");
			for(String station : s) {
				int statN = Integer.parseInt(station);
				if(statN == -1) break;
				stations[statN].add(i);
				lines[i].add(statN);
			}
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		
		answer = solve(start, end);
		System.out.println(answer);
	}
	private static int solve(int start, int end) {
		// 환승 횟수를 기준으로 우선순위를 정하는 우선순위 큐를 선언
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.transCount));
		visitedStation[start] = true;
		for(int line : stations[start]) {
			pq.add(new Node(line, start, 0));
			visitedLine[line] = true;
		}
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.curStation == end) {
				return now.transCount;
			}
			for(int nextStation : lines[now.curLine]) {
				if(!visitedStation[nextStation]) {
					visitedStation[nextStation] = true;
					pq.add(new Node(now.curLine, nextStation, now.transCount));
					for(int nextLine : stations[nextStation]) {
						if(!visitedLine[nextLine]) {
							visitedLine[nextLine] = true;
							pq.add(new Node(nextLine, nextStation, now.transCount + 1));
						}
					}
				}
			}
			
		}
		return -1;
	}
	static class Node{
		int curLine;
		int curStation;
		int transCount;
		public Node(int curLine, int cutStation, int transCount) {
			this.curLine = curLine;
			this.curStation = cutStation;
			this.transCount = transCount;
		}
		
	}
}
