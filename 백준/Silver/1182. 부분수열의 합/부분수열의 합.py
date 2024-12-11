N, S = map(int, input().split())
arr = list(map(int, input().split()))

result = 0

def dfs(idx, total):
    global result
    # 배열 끝까지 탐색한 경우
    if idx == N:
        if total == S:  # 합이 S와 같으면 카운트
            result += 1
        return
    
    # 현재 요소를 포함하지 않는 경우
    dfs(idx + 1, total)
    # 현재 요소를 포함하는 경우
    dfs(idx + 1, total + arr[idx])

dfs(0, 0)
print(result if S != 0 else result - 1)  # 빈 배열 제외