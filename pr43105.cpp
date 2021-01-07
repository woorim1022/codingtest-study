#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int height;

int solution(vector<vector<int>> triangle) {
    height = triangle.size();

	for (int i = 1; i < height; i++) {
		for (int j = 0; j < triangle[i].size(); j++) {
			//오른쪽위에서만 숫자받음
			if (j == 0){
				triangle[i][j] += triangle[i - 1][j];
			}
			//왼쪽위에서만 숫자받음
			else if (j == triangle[i].size() - 1) {
				triangle[i][j] += triangle[i - 1][j - 1];
			}
			//왼쪽 오른쪽에서 둘다 받아서 더 큰 수 선택
			else
			{
				triangle[i][j] += max(triangle[i - 1][j], triangle[i - 1][j - 1]);
			}
		}
	}

	int max = 0;
	for (int i = 0; i < triangle[height - 1].size(); i++) {
		if (triangle[height - 1][i] > max)
			max = triangle[height - 1][i];
	}


	return max;
}