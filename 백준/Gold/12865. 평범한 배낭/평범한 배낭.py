import sys

# 입력 받기
n, k = map(int, sys.stdin.readline().split())  # 물건 개수 N, 최대 무게 K

# 물건 정보를 별도 배열로 저장
weights = [0] * (n + 1)
values = [0] * (n + 1)

for i in range(1, n + 1):
    weights[i], values[i] = map(int, sys.stdin.readline().split())

# DP 배열 초기화 (2차원 배열)
dp = [[0] * (k + 1) for _ in range(n + 1)]

# DP 테이블 채우기
for i in range(1, n + 1):
    for w in range(k + 1):
        if weights[i] > w:  
            # 현재 물건을 담을 수 없는 경우 (이전 값 유지)
            dp[i][w] = dp[i - 1][w]
        else:  
            # 현재 물건을 담을 수 있는 경우 (최댓값 갱신)
            dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i]] + values[i])

# 최대 가치 출력
print(dp[n][k])
