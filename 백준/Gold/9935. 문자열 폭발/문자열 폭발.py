str = list(input())
bomb = input()
stack = []

for char in str:
    stack.append(char)
    if len(stack) >= len(bomb) and ''.join(stack[-len(bomb):]) == bomb:
        del stack[-len(bomb):]

answer = "".join(stack)
if answer == "":
    print("FRULA")
else:
    print(answer)
