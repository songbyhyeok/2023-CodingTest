#include <iostream>

using namespace std;

int solution(int n) {
    int ans = 0;

    while(0 < n) {
        ans += n % 2;
        n = n >> 1;
    }

    return ans;
}
