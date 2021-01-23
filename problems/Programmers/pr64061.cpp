#include <string>
#include <vector>
#include <iostream>
#include <stack>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
   int answer = 0;
	int col;
	int pick;
	stack<int> s;
	for(int i = 0; i < moves.size(); i++) {
		col = moves[i] - 1;
		pick = 0;
		for (int j = 0; j < board.size(); j++) {
			if (board[j][col] != 0) {
				pick = board[j][col];
				board[j][col] = 0;
				break;
			}
		}
		if (pick == 0) continue;
		else {
			if ((!s.empty()) && (s.top() == pick)) {
				s.pop();
				answer+=2;
			}
			else s.push(pick);
		}
	}
	

	cout << answer;


	return answer;
}