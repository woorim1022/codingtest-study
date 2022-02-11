package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//K년이 지난 후 상도의 땅에 살아있는 나무의 개수를 구하라
public class BOJ16235_나무재테크 {
	public static class Tree implements Comparable<Tree> {
		int x, y, z; // 나무의 위치 (x,y), 나무의 나이
		public Tree(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(Tree target) { // 오름차순 정렬
			// return this.z/* 새로들어온애 */ >= target.z/* 원래있던애 */ ? 1/* 위치그대로 */ : -1/* 위치바꿔줌
			// */;
			return this.z - target.z;
			// 새로 들어온 나무(this)의 나이가 원래 있던 나무(other)의 나이보다 크면 위치를 그대로 둔다
			// 새로들어온 나무의 나이가 더 작으면 위치를 바꿔준다
		}
		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", z=" + z + "]";
		}
	}

	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int N, M, K;
	static int[][] A; // 각 땅에 추가되는 양분의 양
	static int[][] land; // 땅에 현재 들어있는 양분
	static PriorityQueue<Tree> trees;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1][N + 1];
		land = new int[N + 1][N + 1];
		trees = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				land[i][j] = 5;

				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			trees.offer(new Tree(x, y, z)); // 현재 삽입되는 tree의 나이가 compareTo()의 기준값(this)
		}

		solve();

		System.out.println(answer);

	}

	static public void solve() {
		for (int i = 0; i < K; i++) {
			ArrayList<Tree> dead = spring();
			summer(dead);
			fall();
			winter();
		}
		answer = trees.size();
	}

	private static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				land[i][j] += A[i][j];
			}
		}
	}

	private static void fall() {
		ArrayList<Tree> temp = new ArrayList<>();
		while (!trees.isEmpty()) {
			Tree curTree = trees.poll();
			int r = curTree.x;
			int c = curTree.y;
			int age = curTree.z;
			temp.add(curTree);
			if (age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 1 || nc < 1 || nr > N || nc > N)
						continue;
					temp.add(new Tree(nr, nc, 1));
				}
			}
		}
		for (int i = 0; i < temp.size(); i++) {
			trees.offer(temp.get(i));
		}
	}

	private static void summer(ArrayList<Tree> dead) {
		for (int i = 0; i < dead.size(); i++) {
			Tree tree = dead.get(i);
			int r = tree.x;
			int c = tree.y;
			int age = tree.z;
			land[r][c] += age / 2;
		}
	}

	private static ArrayList<Tree> spring() {
		ArrayList<Tree> grown = new ArrayList<>();
		ArrayList<Tree> dead = new ArrayList<>();
		while (!trees.isEmpty()) {
			Tree curTree = trees.poll();
			int r = curTree.x;
			int c = curTree.y;
			int age = curTree.z;
			if (land[r][c] - age < 0) {
				dead.add(new Tree(r, c, age));
				continue;
			}
			land[r][c] = land[r][c] - age; // 나이만큼 양분 냠
			age++; // 한살 머금
			grown.add(new Tree(r, c, age));
		}
		for (int i = 0; i < grown.size(); i++) {
			trees.offer(grown.get(i));
		}
		return dead;
	}

	static public void printLand() {
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				System.out.print(land[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
