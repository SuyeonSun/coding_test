N = int(input())
arr = list(map(int, input().split()))
C = int(input())
for i in range(C):
    gender, number = map(int, input().split())

    if gender == 1:
        for i in range(N):
            if (i + 1) % number == 0:
                if arr[i] == 1:
                    arr[i] = 0
                else:
                    arr[i] = 1
    else:
        if arr[number - 1] == 0:
            arr[number - 1] = 1
        else:
            arr[number - 1] = 0
        left = number - 1 - 1
        right = number - 1 + 1
        while True:
            if left < 0 or right >= len(arr):
                break
            if arr[left] == arr[right]:
                if arr[left] == 1:
                    arr[left] = 0
                    arr[right] = 0
                else:
                    arr[left] = 1
                    arr[right] = 1
                left -= 1
                right += 1
            else:
                break
# 결과 출력 (20개씩 한 줄에 출력)
for i in range(N):
    print(arr[i], end=' ')
    if (i + 1) % 20 == 0:
        print()  # 20개 출력 후 줄바꿈

# 만약 N이 20의 배수가 아닐 때 마지막 줄을 추가로 출력
if N % 20 != 0:
    print()