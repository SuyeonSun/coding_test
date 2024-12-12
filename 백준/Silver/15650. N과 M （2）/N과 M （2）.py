N, M = map(int, input().split())
arr = [0] * M

def dfs(index, depth, arr):
    if depth == M:
        print(*arr)
        return
    for i in range(index, N):
        arr[depth] = i + 1
        dfs(i + 1, depth + 1, arr)

dfs(0, 0, arr)