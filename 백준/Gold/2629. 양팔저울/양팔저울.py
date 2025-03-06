import sys

# 입력 처리
input = sys.stdin.read
data = input().split()

n = int(data[0])  # 추의 개수
weights = list(map(int, data[1:n+1]))
m = int(data[n+1])  # 구슬 개수
marbles = list(map(int, data[n+2:]))

# DP 배열 크기 설정
MAX_WEIGHT = sum(weights)  # 최대 무게
dp = [[False] * (MAX_WEIGHT + 1) for _ in range(n + 1)]
dp[0][0] = True  # 초기 상태: 무게 0은 항상 가능

# DP 진행
for i in range(1, n + 1):
    weight = weights[i - 1]  # 현재 추의 무게
    for j in range(MAX_WEIGHT + 1):
        if dp[i - 1][j]:  # 이전 상태에서 가능한 무게라면
            dp[i][j] = True  # 그대로 유지
            if j + weight <= MAX_WEIGHT:
                dp[i][j + weight] = True  # 현재 추를 더한 경우
            if abs(j - weight) <= MAX_WEIGHT:
                dp[i][abs(j - weight)] = True  # 현재 추를 뺀 경우

# 결과 확인
result = []
for marble in marbles:
    if marble <= MAX_WEIGHT and dp[n][marble]:
        result.append("Y")
    else:
        result.append("N")

print(" ".join(result))
