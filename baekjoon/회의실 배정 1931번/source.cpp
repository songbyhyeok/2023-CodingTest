#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<pair<int, int>> Meetings;
pair<int, int> CurrMeeting;
int Cnt = 1;
int N;

bool compare(const pair<int, int> &a, const pair<int, int> &b) {
    if (a.second == b.second)
        return a.first < b.first;
    
    return a.second < b.second;
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    // 입력
    cin >> N;
    Meetings.resize(N);
    for (register int i = 0; i < N; i++) {
        cin >> Meetings[i].first;
        cin >> Meetings[i].second;
    }

    // 정렬
    sort(Meetings.begin(), Meetings.end(), compare);

    // 회의실 배정 조사
    CurrMeeting = move(Meetings[0]);
    for (int i = 1; i < N; i++) {
        const pair<int, int>& nextMeeting = Meetings[i];

        // 현재 끝나는 시간보다 같거나 크다면 바로 현재 회의실 변경
        if (CurrMeeting.second <= nextMeeting.first) {
            CurrMeeting = move(Meetings[i]);
            ++Cnt;
        }
    }

    cout << Cnt;
    return 0;
}