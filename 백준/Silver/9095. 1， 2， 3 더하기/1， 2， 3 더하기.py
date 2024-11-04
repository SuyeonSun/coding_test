n = int(input())
for _ in range(n):
    m = int(input())
    if m == 0:
        print(0)
        continue
    elif m == 1:
        print(1)
        continue
    elif m == 2:
        print(2)
        continue
    elif m == 3:
        print(4)
        continue

    dp = [0] * (m + 1)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for i in range(4, m + 1):
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    print(dp[m])