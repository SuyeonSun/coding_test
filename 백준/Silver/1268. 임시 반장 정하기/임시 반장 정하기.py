N = int(input())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))

max_friends = 0
answer = 0
for x in range(N):
    s = set()
    for y in range(5):
        for z in range(N):
            if arr[x][y] == arr[z][y]:
                s.add(z)
    if len(s) > max_friends:
        max_friends = len(s)
        answer = x + 1
print(answer)

