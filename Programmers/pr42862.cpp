#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    vector<int> student(n, 1);
        for (int j = 0; j < lost.size(); j++) {
			if (student[lost[j] - 1] != 0)
				student[lost[j] - 1]--;
		}
		for (int j = 0; j < reserve.size(); j++) {
			student[reserve[j] - 1] += 1;
		}
		

		for (int i = 0; i < n; i++) {
			if (student[i] == 0) {
				if (student[i - 1] == 2 && i > 0) {
					student[i - 1]--;
					student[i]++;
				}
				else if (student[i + 1] == 2 && i + 1 < n) {
					student[i + 1]--;
					student[i]++;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (student[i] != 0)
				count++;
		}

		cout << count;

	return count;
}