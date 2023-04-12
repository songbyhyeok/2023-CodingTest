#include <stdio.h>

int main(void) {
	int n, s, r;
	int teams[11]{};
	int answer = 0;

	scanf_s("%d %d %d", &n, &s, &r);

	for (int i = 0, teamN; i < s; i++) {
		scanf_s("%d", &teamN);
		--teams[teamN];
	}
	
	for (int i = 0, teamN; i < r; i++) {
		scanf_s("%d", &teamN);
		++teams[teamN];
	}

	for (int i = 1; i <= n; i++) {
		if (teams[i] == -1) {
			if (teams[i - 1] == 1) {
				++teams[i];
				--teams[i - 1];
			}
			else if (teams[i + 1] == 1) {
				++teams[i];
				--teams[i + 1];
			}
		}
	}
	
	for (int i = 1; i <= n; i++) {
		if (teams[i] == -1)
			++answer;
	}

	printf("%d", answer);

	return 0;
}