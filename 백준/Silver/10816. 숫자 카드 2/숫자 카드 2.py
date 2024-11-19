from collections import Counter

N = int(input())
an = list(map(int, input().split()))
an.sort()

M = int(input())
am = list(map(int, input().split()))

an_count = Counter(an)

answer = []
for i in am:
    start = 0
    end = len(an) - 1
    is_find = False
    while start <= end:
        mid = (start + end) // 2
        if i == an[mid]:
            answer.append(an_count[i])
            is_find = True
            break
        elif i < an[mid]:
            end = mid - 1
        else:
            start = mid + 1
    if not is_find:
        answer.append(0)

print(" ".join(str(num) for num in answer))