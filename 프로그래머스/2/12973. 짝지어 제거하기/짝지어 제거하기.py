def solution(s):
    answer = -1

    stack = []
    
    for str in s:
        if (len(stack) == 0):
            stack.append(str)
        else:
            if (stack[-1] == str):
                stack.pop()
            else:
                stack.append(str)
                
    if (len(stack) == 0):
        answer = 1
    else:
        answer = 0
    return answer