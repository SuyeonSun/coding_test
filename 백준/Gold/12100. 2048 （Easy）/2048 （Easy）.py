import sys
import copy

# 입력 받기
N = int(sys.stdin.readline())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

# 보드 이동 함수
def move(board, direction):
    new_board = [[0] * N for _ in range(N)]
    
    if direction == 0:  # 위쪽 이동
        for c in range(N):
            queue, merged = [], [False] * N
            for r in range(N):
                if board[r][c] == 0:
                    continue
                if queue and queue[-1] == board[r][c] and not merged[len(queue)-1]:
                    queue[-1] *= 2
                    merged[len(queue)-1] = True  # 합쳐졌음을 표시
                else:
                    queue.append(board[r][c])
            for i in range(len(queue)):
                new_board[i][c] = queue[i]

    elif direction == 1:  # 아래쪽 이동
        for c in range(N):
            queue, merged = [], [False] * N
            for r in range(N-1, -1, -1):
                if board[r][c] == 0:
                    continue
                if queue and queue[-1] == board[r][c] and not merged[len(queue)-1]:
                    queue[-1] *= 2
                    merged[len(queue)-1] = True
                else:
                    queue.append(board[r][c])
            for i in range(len(queue)):
                new_board[N-1-i][c] = queue[i]

    elif direction == 2:  # 왼쪽 이동
        for r in range(N):
            queue, merged = [], [False] * N
            for c in range(N):
                if board[r][c] == 0:
                    continue
                if queue and queue[-1] == board[r][c] and not merged[len(queue)-1]:
                    queue[-1] *= 2
                    merged[len(queue)-1] = True
                else:
                    queue.append(board[r][c])
            for i in range(len(queue)):
                new_board[r][i] = queue[i]

    elif direction == 3:  # 오른쪽 이동
        for r in range(N):
            queue, merged = [], [False] * N
            for c in range(N-1, -1, -1):
                if board[r][c] == 0:
                    continue
                if queue and queue[-1] == board[r][c] and not merged[len(queue)-1]:
                    queue[-1] *= 2
                    merged[len(queue)-1] = True
                else:
                    queue.append(board[r][c])
            for i in range(len(queue)):
                new_board[r][N-1-i] = queue[i]

    return new_board

# DFS 탐색
def dfs(board, depth):
    global max_value
    max_value = max(max_value, max(map(max, board)))  # 최대값 갱신

    if depth == 5:
        return

    for d in range(4):
        new_board = move(copy.deepcopy(board), d)
        if new_board != board:  # 이동이 발생했을 경우에만 재귀 호출
            dfs(new_board, depth + 1)

# 최대값 저장 변수
max_value = 0
dfs(board, 0)

# 정답 출력
print(max_value)