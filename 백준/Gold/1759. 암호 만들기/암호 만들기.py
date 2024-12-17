N, M = map(int, input().split())
arr = list(input().split())
arr.sort()
result = [''] * N
visited = [False] * M
moem = ['a', 'e', 'i', 'o', 'u']

def dfs(index, depth, result):
    if depth == N:
        moem_cnt = 0
        jaem_cnt = 0
        for j in result:
            if j in moem:
                moem_cnt += 1
            else:
                jaem_cnt += 1
        if moem_cnt >= 1 and jaem_cnt >= 2:
            print("".join(result))
        return
    for i in range(index, len(arr)):
        if not visited[depth]:
            visited[depth] = True
            result[depth] = arr[i]
            dfs(i + 1, depth + 1, result)
            visited[depth] = False

dfs(0, 0, result)