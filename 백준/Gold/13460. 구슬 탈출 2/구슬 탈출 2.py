from collections import deque
import sys

input = sys.stdin.readline

# 방향 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def move(x, y, dx, dy, board):
    """벽(#)을 만나기 전까지 이동하며, 구멍(O)을 만나면 멈춤"""
    count = 0  # 이동 거리
    while board[x + dx][y + dy] != "#" and board[x][y] != "O":
        x += dx
        y += dy
        count += 1
    return x, y, count  # 이동한 좌표와 이동 거리 반환

def bfs(board, rx, ry, bx, by):
    queue = deque()
    queue.append((rx, ry, bx, by, 0))  # (빨간 구슬 x, y, 파란 구슬 x, y, 이동 횟수)
    visited = set()  # 방문한 상태 저장
    visited.add((rx, ry, bx, by))

    while queue:
        rx, ry, bx, by, depth = queue.popleft()

        if depth >= 10:  # 10번 넘으면 실패
            return -1
        
        for i in range(4):  # 상하좌우로 기울이기
            nrx, nry, r_count = move(rx, ry, dx[i], dy[i], board)
            nbx, nby, b_count = move(bx, by, dx[i], dy[i], board)

            # 파란 구슬이 구멍에 빠지면 실패
            if board[nbx][nby] == "O":
                continue  # 해당 방향은 무시하고 다음 방향 탐색
            
            # 빨간 구슬이 구멍에 빠지면 성공
            if board[nrx][nry] == "O":
                return depth + 1  # 이동 횟수 반환
            
            # 두 구슬이 같은 위치에 있다면 이동 거리(count) 비교 후 조정
            if nrx == nbx and nry == nby:
                if r_count > b_count:  # 더 늦게 온 구슬을 한 칸 뒤로 이동
                    nrx -= dx[i]
                    nry -= dy[i]
                else:
                    nbx -= dx[i]
                    nby -= dy[i]

            # 방문하지 않은 상태라면 큐에 추가
            if (nrx, nry, nbx, nby) not in visited:
                visited.add((nrx, nry, nbx, nby))
                queue.append((nrx, nry, nbx, nby, depth + 1))

    return -1  # 10번 이내에 해결 못 하면 실패

# 입력 처리
N, M = map(int, input().split())
board = [list(input().strip()) for _ in range(N)]

rx, ry, bx, by = 0, 0, 0, 0  # 빨간, 파란 구슬 위치 저장

for i in range(N):
    for j in range(M):
        if board[i][j] == "R":
            rx, ry = i, j
        elif board[i][j] == "B":
            bx, by = i, j

# BFS 실행
print(bfs(board, rx, ry, bx, by))
