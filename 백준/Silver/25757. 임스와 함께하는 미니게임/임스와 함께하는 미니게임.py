games = {"Y": 2, "F": 3, "O": 4}
N, K = input().split()
N = int(N)

answer = 0
played = set()
cnt = 0
for i in range(N):
    name = input()
    if name in played:
        continue
    else:
        played.add(name)
        cnt += 1
        if cnt == games[K] - 1:
            answer += 1
            cnt = 0

print(answer)