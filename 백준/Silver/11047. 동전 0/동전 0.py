N, K = map(int, input().split())
arr = []
for i in range(N):
    arr.append(int(input()))
arr.sort(reverse = True)

answer = 0
idx = 0

while K > 0:
    if arr[idx] > K:
        idx += 1
        continue
    answer += (K // arr[idx])
    K %= arr[idx]
    idx += 1

print(answer)