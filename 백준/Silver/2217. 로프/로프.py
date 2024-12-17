# k개의 로프
# w의 중량
# w/k만큼의 중량

n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))
arr.sort()

answers = []
for i in arr:
    answers.append(i * n)
    n -= 1

print(max(answers))