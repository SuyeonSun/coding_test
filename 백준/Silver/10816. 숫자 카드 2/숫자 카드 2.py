from collections import Counter

N = int(input())
an = list(map(int, input().split()))
an.sort()

M = int(input())
am = list(map(int, input().split()))

an_count = Counter(an)

answer = []
for i in am:
    answer.append(an_count[i])

print(" ".join(str(num) for num in answer))