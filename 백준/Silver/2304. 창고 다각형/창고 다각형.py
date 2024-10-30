# 창고의 높이를 입력받습니다.
n = int(input())
heights = [0] * 1001  # 최대 1000개의 막대 위치를 가지므로 1001 크기의 배열 생성

# 입력받은 위치와 높이를 기록합니다.
for _ in range(n):
    pos, height = map(int, input().split())
    heights[pos] = height

# 가장 높은 위치와 그 높이를 찾습니다.
max_height = max(heights)
max_index = heights.index(max_height)

# 왼쪽에서 최대 높이까지 넓이 계산
left_area = 0
current_height = 0
for i in range(max_index + 1):
    current_height = max(current_height, heights[i])
    left_area += current_height

# 오른쪽에서 최대 높이까지 넓이 계산
right_area = 0
current_height = 0
for i in range(1000, max_index, -1):
    current_height = max(current_height, heights[i])
    right_area += current_height

# 전체 넓이는 좌우 넓이의 합
total_area = left_area + right_area
print(total_area)