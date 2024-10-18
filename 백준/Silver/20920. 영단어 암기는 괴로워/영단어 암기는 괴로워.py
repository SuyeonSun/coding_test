# M 이상인 단어들만 외운다.
# 1. 자주 나오는 단어일수록 앞에 배치한다.
# 2. 해당 단어의 길이가 길수록 앞에 배치한다.
# 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.

import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split()) # 단어 개수, 단어 길이
word_list = {}

for i in range(N):
    word = input().rstrip()

    if len(word) >= M:
        if word in word_list:
            word_list[word] += 1
        else:
            word_list[word] = 1

word_list = sorted(word_list.items(), key = lambda x : (-x[1], -len(x[0]), x[0]))
# -x[1] = 자주 나오는 단어 앞에 배치
# -len(x[0]) = 단어 길이 길수록 앞에 배치
# x[0] = 단어 사전 순 정렬

for i in word_list:
    print(i[0])