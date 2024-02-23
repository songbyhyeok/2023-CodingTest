#include <iostream>
#include <vector>

using namespace std;

// ���� 9012�� ��ȣ
// �ùٸ� �ѽ��� ��ȣ�� VSP��� �Ѵ�.
// �Է¶����� ��ȣ ������ �־����µ� VSP���� �������� �ƴ��� NO, YES��
// �а��ϴ� ������.

// ) ������ �� �� ��ȣ ( �� ������ ���� �ʴٸ� NO
// �ݺ����� ������ ������ ��ȣ�� �����ִٸ� NO

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
		// ��ȣ�� VSP���� ����
		for (const auto& bracket : brackets) {
			switch (bracket) {
			case '(':
				vecStack.emplace_back('(');
				break;
			case ')':
				// ���� ��ȣ�� ����ְų� ���� ��ȣ��� �ѽ��� �� �� ����.
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