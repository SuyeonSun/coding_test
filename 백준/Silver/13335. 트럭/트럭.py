from collections import deque

n, w, l = map(int, input().split())  # 트럭 수, 다리 길이, 다리 최대 하중
trucks = list(map(int, input().split()))  # 트럭 무게 리스트

bridge = deque([0] * w) # 다리 위를 나타내는 큐
current_weight = 0 # 현재 다리 위의 총 무게
time = 0 # 경과 시간

for truck in trucks:
    while True:
        # 다리의 맨 앞 트럭(혹은 빈 자리) 제거
        current_weight -= bridge.popleft()

        # 다리에 트럭을 올릴 수 있는지 확인
        if current_weight + truck <= l:
            bridge.append(truck) # 트럭을 다리에 올림
            current_weight += truck
            time += 1
            break
        else:
            # 올릴 수 없으면 빈 자리를 추가하여 시간을 경과시킴
            bridge.append(0)
            time += 1

# 마지막 트럭이 다리를 건너는 시간 추가
time += w

print(time)