package com.woorim.problems;

import java.lang.*;
import java.util.*;
import java.io.*;

//typ=-1, 행번호+열번호 같은 칸끼리 같은 대각선으로 묶는다 
//typ=1, 행번호-열번호 같은 칸끼리 같은 대각선으로 묶는다
// 해당 부분 직사각형 영역을 대각선 별로 나눈 다음에, 각 대각선의 모든 숫자들을 대각방향으로 반전

//딕셔너리
class Solution3 {
    int R, C;
    int[][] gridM;

    public int[][] solution(int[][] grid, int[][] queries) {
        R = grid.length;
        C = grid[0].length;
        gridM = grid;
        for (int i = 0; i < queries.length; i++) {
            int r1, c1, r2, c2, typ;
            r1 = queries[i][0];
            c1 = queries[i][1];
            r2 = queries[i][2];
            c2 = queries[i][3];
            typ = queries[i][4];
            solve(r1, c1, r2, c2, typ);
        }
        return gridM;
    }

    public void solve(int r1, int c1, int r2, int c2, int typ) {
        // 같은 대각선의 숫자를 추출한 뒤
        // 서로 반전시키고
        // 다시 사각형에 이식한다.
        if (typ == -1) { // 경우의 수 : r1+c1 ~ r2+c2
            for (int sum = r1 + c1; sum <= r2 + c2; sum++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        if (r + c == sum) {
                            list.add(gridM[r][c]);
                        }
                    }
                }
                // 리스트값들 교환해줘
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != list.get(list.size() - 1 - i)) {
                        int temp = list.get(list.size() - 1 - i);
                        list.set(list.size() - 1 - i, list.get(i));
                        list.set(i, temp);
                    }
                }
                int idx = 0;
                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        if (r + c == sum) {
                            gridM[r][c] = list.get(idx++);
                        }
                    }
                }
            }
        } else { // r1-c2 ~ r2-c1
            for (int minus = r2 - c1; minus <= r1 - c2; minus++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        if (r - c == minus) {
                            list.add(gridM[r][c]);
                        }
                    }
                }
                // 리스트값들 교환해줘
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != list.get(list.size() - 1 - i)) {
                        int temp = list.get(list.size() - 1 - i);
                        list.set(list.size() - 1 - i, list.get(i));
                        list.set(i, temp);
                    }
                }
                int idx = 0;
                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        if (r + c == minus) {
                            gridM[r][c] = list.get(idx++);
                        }
                    }
                }
            }
        }
    }
}
