from collections import deque

N, K = map(int, input().split())

queue = deque([])
for i in range(N):
    queue.append(i + 1)

answer = []
while True:
    if not queue:
        break
    for i in range(K-1):
        number = queue.popleft()
        queue.append(number)
    answer.append(queue.popleft())

result = "<" + ", ".join(map(str, answer)) + ">"
print(result)