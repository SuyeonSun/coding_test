N = int(input())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))

# 종료 시간을 기준으로 정렬, 종료 시간이 같으면 시작 시간 기준으로 정렬
arr = sorted(arr, key = lambda x: (x[1], x[0]))

answer = [arr[0]]  
for i in range(1, N):
    if arr[i][0] >= answer[-1][1]:
        answer.append(arr[i])

print(len(answer))