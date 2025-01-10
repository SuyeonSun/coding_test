N = int(input())
arr = []
for i in range(N):
    arr.append(int(input()))

if N == 1:
    print(0)
else:
    da = arr[0]
    arr = arr[1:]

    answer = 0
    while True:
        arr.sort(reverse = True)
        if arr[0] >= da:
            da += 1
            arr[0] -=1
            answer += 1
        else:
            break

    print(answer)