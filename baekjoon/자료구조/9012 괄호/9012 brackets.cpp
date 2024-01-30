#include <iostream>
#include <vector>

using namespace std;

// 백준 9012번 괄호
// 올바른 한쌍의 괄호를 VSP라고 한다.
// 입력란에서 괄호 모음이 주어지는데 VSP들의 집합인지 아닌지 NO, YES로
// 분간하는 문제다.

// ) 문자일 때 역 괄호 ( 를 가지고 있지 않다면 NO
// 반복문이 끝나고 잔존한 괄호가 남아있다면 NO

int N;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string brackets = "";

	cin >> N;
	for (int i = 0; i < N; i++) {
		vector<char> vecStack;
		bool hasVSP = true;

		cin >> brackets;
		// 괄호가 VSP인지 검토
		for (const auto& bracket : brackets) {
			switch (bracket) {
			case '(':
				vecStack.emplace_back('(');
				break;
			case ')':
				// 이전 괄호가 비어있거나 같은 괄호라면 한쌍이 될 수 없다.
				if (vecStack.empty() || vecStack.back() == ')')
					hasVSP = false;
				else if (vecStack.back() == '(')
					vecStack.pop_back();
				break;
			}

			if (hasVSP == false)
				break;
		}

		if (hasVSP == false || !vecStack.empty())
			cout << "NO" << '\n';
		else 
			cout << "YES" << '\n';
	}
	
	return 0;
}