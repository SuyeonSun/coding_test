answer = []
sinario = 1
while True:
    N = int(input())
    if N == 0:
        break
    names = []
    cnt = [0 for _ in range(N)]
    for i in range(N):
        name = input()
        names.append(name)
    for i in range(2*N - 1):
        num, alpha = input().split()
        num = int(num)
        if cnt[num-1] == 1:
            cnt[num-1] = 0
        else:
            cnt[num-1] = 1
    for i in range(N):
        if cnt[i] == 1:
            answer.append([sinario, names[i]])
            sinario += 1
            break
for a, b in answer:
    print(a, b)