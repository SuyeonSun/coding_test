N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
result = [0] * M
visited = [False] * N

def dfs(index, depth, result, visited):
    if depth == M:
        print(*result)
        return
    
    for i in range(index, len(arr)):
        if not visited[i]:
            result[depth] = arr[i]
            visited[i] = True
            dfs(i + 1, depth + 1, result, visited)
            visited[i] = False

dfs(0, 0, result, visited)