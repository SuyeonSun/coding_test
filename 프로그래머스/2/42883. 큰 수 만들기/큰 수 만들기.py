def solution(number, k):
    stack = []
    
    for num in number:
        # 스택의 마지막 숫자가 현재 숫자보다 작고 제거할 수 있는 k가 남아있으면 제거
        while stack and k > 0 and stack[-1] < num:
            stack.pop()
            k -= 1
        stack.append(num)
    
    # 아직 제거해야 할 k가 남아있다면 뒤에서부터 제거
    if k > 0:
        stack = stack[:-k]
    
    return ''.join(stack)