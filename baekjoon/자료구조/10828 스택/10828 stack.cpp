#include <iostream>
#include <vector>

using namespace std;

int N;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	vector<int> vecStack;
	string inputValue = "";

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> inputValue;
		
		if (inputValue == "push") {
			int additional = 0;
			cin >> additional;
			vecStack.emplace_back(additional);
		}
		else if (inputValue == "pop") {
			int printVal = 0;
			if (vecStack.empty() == true) {
				printVal = -1;
			}
			else {
				printVal = vecStack.back();
				vecStack.pop_back();
			}

			cout << printVal << '\n';
		}
		else if (inputValue == "size") {
			cout << vecStack.size() << '\n';
		}
		else if (inputValue == "empty") {
			cout << ((vecStack.empty() == true) ? 1 : 0) << '\n';
		}
		else if (inputValue == "top") {
			cout << ( (vecStack.empty() == false) ? vecStack.back() : -1) << '\n';
		}
	}
	
	return 0;
}
