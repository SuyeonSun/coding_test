N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
result = [0] * M
answer = set()

def dfs(depth, result):
    if depth == M:
        answer.add(tuple(result))
        return
    for i in range(len(arr)):
        result[depth] = arr[i]
        dfs(depth + 1, result)
    
dfs(0, result)

for combination in sorted(answer):
    print(' '.join(map(str, combination)))