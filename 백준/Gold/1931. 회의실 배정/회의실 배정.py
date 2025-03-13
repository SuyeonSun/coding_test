N = int(input())
arr = []
for i in range(N):
    start, end = map(int, input().split())
    arr.append([start, end])
arr = sorted(arr, key = lambda x : [x[1], x[0]])

answer = 1
last_idx = 0
for i in range(1, len(arr)):
    if arr[last_idx][1] <= arr[i][0]:
        answer += 1
        last_idx = i
print(answer)
