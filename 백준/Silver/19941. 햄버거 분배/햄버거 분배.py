n, k = map(int, input().split())
array = list(input())
answer = 0
for i in range(n):
    if array[i] == "P": # i: 현재 사람 P가 위치한 인덱스
        for j in range(max(i - k, 0), min(i + k + 1, n)): # # 리스트의 경계를 벗어나지 않도록
            if array[j] == "H":
                array[j] = 0
                answer += 1
                break
print(answer)