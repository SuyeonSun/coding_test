N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
result = [0] * M

def dfs(depth, result):
    if depth == M:
        print(*result)
        return
    for i in range(len(arr)):
        result[depth] = arr[i]
        dfs(depth + 1, result)

dfs(0, result)