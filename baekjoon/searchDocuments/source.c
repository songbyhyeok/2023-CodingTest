#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define DOCUMENT_LEN 2501
#define WORD_LEN 51

int main(void) {
    char document[DOCUMENT_LEN];
    char word[WORD_LEN];
    int answer = 0;

    gets_s(document);
    gets_s(word);
    const int wordLen = strlen(word);
    
    for(int i = 0; i < strlen(document); i++) {
        bool flag = true;
        for (int j = 0; j < wordLen; j++) {
            // �ϳ��� �ƴ϶��
            if (document[i + j] != word[j]) {
                flag = false;
                break;
            }
        }
        
        if (flag) {
            // ������ ũ�� �������� ��ġ�� �ѱ��.
            i += wordLen - 1;
            ++answer;
        }
    }

    printf("%d", answer);

    return 0;
}
