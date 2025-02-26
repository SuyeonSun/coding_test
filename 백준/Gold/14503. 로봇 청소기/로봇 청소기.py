import sys

# 입력 처리
input = sys.stdin.read
data = input().split("\n")
N, M = map(int, data[0].split())
r, c, d = map(int, data[1].split())
room = [list(map(int, line.split())) for line in data[2:N+2]]

# 방향 벡터 (북, 동, 남, 서)
dx = [-1, 0, 1, 0]  # x 좌표 변화 (위, 오른쪽, 아래, 왼쪽)
dy = [0, 1, 0, -1]  # y 좌표 변화 (위, 오른쪽, 아래, 왼쪽)

# 청소 카운트
count = 0

while True:
    # 1. 현재 위치 청소
    if room[r][c] == 0:
        room[r][c] = 2  # 청소 완료
        count += 1

    # 2. 네 방향 확인
    moved = False
    for _ in range(4):
        d = (d + 3) % 4  # 왼쪽으로 회전
        nx, ny = r + dx[d], c + dy[d]

        # 청소되지 않은 칸이 있으면 이동
        if 0 <= nx < N and 0 <= ny < M and room[nx][ny] == 0:
            r, c = nx, ny
            moved = True
            break

    # 3. 네 방향 모두 청소된 경우 후진
    if not moved:
        back_d = (d + 2) % 4  # 후진 방향
        br, bc = r + dx[back_d], c + dy[back_d]

        if 0 <= br < N and 0 <= bc < M and room[br][bc] != 1:  # 벽이 아니면 후진
            r, c = br, bc
        else:
            break  # 후진 불가능하면 종료

# 결과 출력
print(count)
