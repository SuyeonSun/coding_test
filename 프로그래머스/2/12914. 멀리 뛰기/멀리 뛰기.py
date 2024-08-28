def solution(n):
    answer = 0
    
    dp = [0] * (n+1) # 특정 길이의 배열 선언 방법
    dp[0] = 1
    dp[1] = 2
    
    for i in range(2, n):
        dp[i] = dp[i-2] + dp[i-1]
    
    answer = dp[n-1] % 1234567
    
    return answer