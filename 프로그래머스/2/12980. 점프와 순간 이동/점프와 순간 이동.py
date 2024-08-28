def solution(n):
    ans = 1 # 처음에는 무조건 한칸을 가야 한다.
    
    while n != 1:
        if n % 2 == 0:
            n /= 2
        else:
            ans += 1
            n -= 1

    return ans