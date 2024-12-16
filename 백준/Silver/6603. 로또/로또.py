def dfs(result, arr, index, depth):
    if depth == 6:
        print(*result)
        return
    for i in range(index, len(arr)):
        result[depth] = arr[i]
        dfs(result, arr, i + 1, depth + 1)

while True:
    s = list(map(int, input().split()))
    if s[0]==0:
        break
    result=[0] * 6
    dfs(result, s[1:], 0, 0)
    print()
