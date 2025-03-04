def conveyor_belt_robot(N, K, durability):
    from collections import deque

    # 벨트와 로봇을 덱(deque)으로 관리 (회전 편리)
    belt = deque(durability)  # 벨트 내구도
    robots = deque([False] * N)  # 로봇 위치 (N개)
    
    step = 0  # 진행 단계

    while True:
        step += 1

        # 1. 벨트 회전 (벨트와 로봇이 함께 회전)
        belt.rotate(1)
        robots.rotate(1)
        robots[-1] = False  # N-1번 칸에 도착한 로봇 즉시 제거

        # 2. 로봇 이동 (N-2번부터 0번까지 역순으로 이동)
        for i in range(N-2, -1, -1):
            if robots[i] and not robots[i+1] and belt[i+1] > 0:
                robots[i] = False
                robots[i+1] = True
                belt[i+1] -= 1  # 내구도 감소
        robots[-1] = False  # 다시 한 번 N-1번에 도달한 로봇 제거

        # 3. 로봇 올리기 (0번 칸에 올릴 수 있으면 올림)
        if belt[0] > 0:
            robots[0] = True
            belt[0] -= 1

        # 4. 내구도 0인 칸 개수 확인
        if belt.count(0) >= K:
            return step

# 입력
N, K = map(int, input().split())
durability = list(map(int, input().split()))

# 결과 출력
print(conveyor_belt_robot(N, K, durability))
