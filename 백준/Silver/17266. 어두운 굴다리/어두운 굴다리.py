def is_enough_light(D, lights, N):
    # 첫 가로등이 0을 비추는지 확인
    if lights[0] > D:
        return False
    
    # 각 가로등 사이의 거리가 D로 커버 가능한지 확인
    for i in range(1, len(lights)):
        if lights[i] - lights[i-1] > 2 * D:
            return False
    
    # 마지막 가로등이 N을 비추는지 확인
    if N - lights[-1] > D:
        return False
    
    return True

def find_min_brightness(N, lights):
    left, right = 0, N
    answer = right
    
    while left <= right:
        mid = (left + right) // 2
        
        if is_enough_light(mid, lights, N):
            answer = mid
            right = mid - 1  # 더 작은 밝기에서도 가능한지 확인
        else:
            left = mid + 1  # 더 큰 밝기를 시도
    
    return answer

# 입력 처리 부분
N = int(input())  # 다리의 길이
M = int(input())  # 가로등의 개수
lights = list(map(int, input().split()))  # 가로등 위치들

# 최소 밝기 출력
print(find_min_brightness(N, lights))
