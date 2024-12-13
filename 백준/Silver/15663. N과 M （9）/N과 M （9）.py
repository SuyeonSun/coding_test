N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
result = [0] * M
visited = [False] * N
answer = set()

def dfs(depth, result, visited):
    if depth == M:
        answer.add(tuple(result))
        return
    for i in range(len(arr)):
        if not visited[i]:
            result[depth] = arr[i]
            visited[i] = True
            dfs(depth + 1, result, visited)
            visited[i] = False

dfs(0, result, visited)

for combination in sorted(answer):
    print(' '.join(map(str, combination)))