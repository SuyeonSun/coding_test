N = int(input())
T = [0 for _ in range(N + 1)] # 상담 기간
P = [0 for _ in range(N + 1)] # 상담 수익 # 3 5 1 1 2 4 2
dp = [0 for _ in range(N+2)] # dp 배열   # 10 20 10 20 15 40 200

for i in range(1, N + 1):
    t, p = map(int, input().split())
    T[i] = t
    P[i] = p

for i in range(1, N + 1):
    dp[i] = max(dp[i], dp[i-1])
    if i + T[i] <= N + 1:
        dp[i + T[i]] = max(dp[i + T[i]], dp[i] +P[i])

print(max(dp))