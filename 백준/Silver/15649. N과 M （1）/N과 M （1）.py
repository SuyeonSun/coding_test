N, M = map(int, input().split())
arr = [0] * M
visited = [False] * N

def dfs(depth, arr, visited):
    if depth == M:
        print(" ".join(map(str, arr)))
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = True
            arr[depth] = i + 1
            dfs(depth + 1, arr, visited)  # 올바른 순서로 dfs 호출
            visited[i] = False

dfs(0, arr, visited)
