N, S = map(int, input().split())
arr = list(map(int, input().split()))

result = 0

def dfs(index, n):
    global result
    if n == S and index > 0:
        result += 1
    for i in range(index, N):
        dfs(i+1, n + arr[i])

dfs(0, 0)
print(result)