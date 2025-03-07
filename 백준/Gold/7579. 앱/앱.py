import sys

# 입력 받기
N, M = map(int, sys.stdin.readline().split())  # 앱 개수, 확보해야 할 메모리
memory = list(map(int, sys.stdin.readline().split()))  # 각 앱이 차지하는 메모리
cost = list(map(int, sys.stdin.readline().split()))  # 각 앱을 비활성화할 때의 비용

max_cost = sum(cost)  # 가능한 최대 비용 (배낭의 최대 무게 개념)
dp = [[0] * (max_cost + 1) for _ in range(N + 1)]  # DP 배열 생성

# DP 수행
for i in range(1, N + 1):  # 앱 개수만큼 반복
    for j in range(max_cost + 1):  # 비용 범위 내에서 반복
        if j < cost[i - 1]:  # 현재 비용으로 앱을 비활성화할 수 없는 경우
            dp[i][j] = dp[i - 1][j]  # 이전 값 유지
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - cost[i - 1]] + memory[i - 1])

# 최소 비용 찾기
for j in range(max_cost + 1):
    if dp[N][j] >= M:
        print(j)  # 최소 비용 출력
        break
