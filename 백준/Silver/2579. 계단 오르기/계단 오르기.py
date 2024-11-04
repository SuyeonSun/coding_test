n = int(input())
stairs = [0]  # 계단 번호를 1부터 시작하기 위해 0 추가
for _ in range(n):
    stairs.append(int(input()))

if n == 1:
    print(stairs[1])
elif n == 2:
    print(stairs[1] + stairs[2])
else:
    dp = [0] * (n + 1)
    dp[1] = stairs[1]
    dp[2] = stairs[1] + stairs[2]
    dp[3] = max(stairs[1] + stairs[3], stairs[2] + stairs[3])

    for i in range(4, n + 1):
        dp[i] = max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i])

    print(dp[n])