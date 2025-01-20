N, K = map(int, input().split())
arr = list(map(int, input().split()))
for i in range(1, len(arr)):
    arr[i] += arr[i-1]
answer = arr[K-1]
for i in range(K, len(arr)):
    diff = arr[i] - arr[i-K]
    answer = max(diff, answer)
print(answer)