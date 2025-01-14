N, M = map(int, input().split())
arr = [0] * M

def dfs(depth, arr):
    if depth == M:
        print(*arr)
        return
    for i in range(1, N+1):
        arr[depth] = i
        dfs(depth + 1, arr)

dfs(0, arr)