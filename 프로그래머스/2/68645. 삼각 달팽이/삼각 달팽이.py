def solution(n):
    # 삼각형을 담을 리스트 초기화
    triangle = [[0] * (i + 1) for i in range(n)]
    
    # 이동 방향: 아래, 오른쪽, 대각선 위로
    dx = [1, 0, -1]
    dy = [0, 1, -1]
    
    # 현재 위치 및 방향 초기화
    x, y = 0, 0
    direction = 0
    
    # 1부터 n(n+1)/2까지 채우기 시작
    for num in range(1, n * (n + 1) // 2 + 1):
        triangle[x][y] = num
        
        # 다음 위치 계산
        nx, ny = x + dx[direction], y + dy[direction]
        
        # 경계를 넘거나 이미 채워진 위치일 경우 방향을 변경
        if nx < 0 or ny < 0 or nx >= n or ny > nx or triangle[nx][ny] != 0:
            direction = (direction + 1) % 3  # 방향 전환
            nx, ny = x + dx[direction], y + dy[direction]
        
        # 새로운 위치로 이동
        x, y = nx, ny
    
    # 2차원 리스트를 1차원 리스트로 변환
    result = []
    for row in triangle:
        result.extend(row)
    
    return result
