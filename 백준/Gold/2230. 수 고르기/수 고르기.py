N, M = map(int, input().split())
arr = [int(input()) for _ in range(N)]

arr.sort()

left = 0
right = 0
answer = float('inf')

while left <= right and right < N:
    diff = arr[right] - arr[left]
    
    # 차이가 M 이상인 경우
    if diff >= M:
        answer = min(answer, diff)
        left += 1  # 구간을 줄이기 위해 left를 증가
   
    else:
        right += 1  # 차이가 부족하므로 right를 증가

print(answer)