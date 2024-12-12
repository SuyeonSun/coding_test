N, M = map(int, input().split())
s = list(map(int, input().split()))
s.sort()
arr = [0] * M
visited = [False] * N

def dfs(depth, arr, visited):
    if depth == M:
        print(*arr)
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = True
            arr[depth] = s[i]
            dfs(depth + 1, arr, visited)  # 올바른 순서로 dfs 호출
            visited[i] = False

dfs(0, arr, visited)