def solution(numbers):
    n = len(numbers)
    answer = [-1] * n  # 기본값을 -1로 초기화
    stack = []

    for i in range(n):
        # 스택이 비어있지 않고, 현재 숫자가 스택의 마지막 숫자보다 큰 경우
        while stack and numbers[stack[-1]] < numbers[i]:
            index = stack.pop()
            answer[index] = numbers[i]
        stack.append(i)
    
    return answer