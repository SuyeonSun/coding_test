def solution(prices):
    answer = []
    for i in range(len(prices)):
        answer.append(0)
    
    stack = [] # 가격이 떨어지지 않은 주식만 남도록 한다.
    
    for i in range(len(prices)):
            while stack and prices[stack[-1]] > prices[i]:
                    pop = stack.pop()
                    diff = i - pop
                    answer[pop] = diff
            stack.append(i)
    
    while stack:
        idx = stack.pop()
        answer[idx] = len(prices) - idx - 1
    
    return answer