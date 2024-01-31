#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
int arr[1005];

int main(void) {
    int n;
    int ans = 0;

    scanf_s("%d", &n);

    for (int i = 0; i < n; i++)
        scanf_s("%d", &arr[i]);

    sort(arr, arr + n);

    for (int i = 0; i < n; i++)
        ans += arr[i] * (n - i);

    printf_s("%d", ans);

    return 0;
}