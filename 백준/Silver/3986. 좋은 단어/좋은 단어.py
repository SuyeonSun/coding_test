answer = 0
N = int(input())
for i in range(N):
    arr = list(input())
    stack = []
    for j in arr:
        if not stack:
            stack.append(j)
        else:
            if stack[-1] == j:
                stack.pop()
            else:
                stack.append(j)
    if len(stack) == 0:
        answer += 1
print(answer)