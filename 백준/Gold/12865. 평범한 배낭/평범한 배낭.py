# https://velog.io/@keynene/Python%ED%8C%8C%EC%9D%B4%EC%8D%AC5-%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-12865-%ED%8F%89%EB%B2%94%ED%95%9C%EB%B0%B0%EB%82%AD
import sys

# 입력 받기
N, K = map(int, sys.stdin.readline().split())  # 물건 개수 N, 최대 무게 K

# 물건 정보를 별도 배열로 저장
weights = [0] * (N + 1)
values = [0] * (N + 1)

for i in range(1, N + 1):
    weights[i], values[i] = map(int, sys.stdin.readline().split())


# DP 배열 초기화 (2차원 배열)
dp = [[0] * (K + 1) for _ in range(N + 1)]

for i in range(1, N + 1): 
    for j in range(1, K + 1):
        if weights[i] > j:  
            # 현재 물건을 넣을 수 없는 경우 (이전 값 유지)
            dp[i][j] = dp[i - 1][j]
        else:  
            # 현재 물건을 넣을 수 있는 경우 (최댓값 갱신)
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i])
            # dp[i - 1][j] : 현재 i번째 물건을 담지 않았을 때의 최대 가치
            # dp[i - 1][j - weights[i]] + values[i] : 현재 물건을 넣기 전에 배낭에 넣을 수 있는 최대 무게를 찾고 거기에 현재 물건의 가치를 더하는 과정

# 최대 가치 출력
print(dp[N][K])
