N = int(input())
numbers = []
for i in range(N):
    numbers.append(input())

answer = 0
digit = 1
while True:
    if digit > 100:
        break
    s = set()
    for number in numbers:
        s.add(number[-digit:])
    if len(s) == N:
        answer = digit
        break
    digit += 1
print(answer)