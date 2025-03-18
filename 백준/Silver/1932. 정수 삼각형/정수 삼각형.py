n = int(input())
dp = [[0 for i in range(n)] for _ in range(n)]
for i in range(n):
    nums = list(map(int, input().split()))
    for j in range(len(nums)):
        dp[i][j] = nums[j]

# 7
# 3 8
# 8 1 0
# 2 7 4 4
# 4 5 2 6 5

for i in range(1, n):
    for j in range(i+1):
        if j == 0:
            dp[i][j] += dp[i-1][j]
        elif j == i:
            dp[i][j] += dp[i-1][j-1]
        else:
            dp[i][j] += max(dp[i-1][j-1], dp[i-1][j])

print(max(dp[-1]))