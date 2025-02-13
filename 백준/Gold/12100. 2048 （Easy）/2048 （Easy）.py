import sys
import copy

N = int(sys.stdin.readline().strip())
pan = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
ans = 0

def move(board, direction):
    new_board = [[0] * N for _ in range(N)]  # 새로운 배열을 만들어 반환

    if direction == 0:  # 왼쪽 이동
        for i in range(N):
            temp = [x for x in board[i] if x != 0]  # 0 제거
            idx = 0
            for j in range(len(temp)):
                if j < len(temp) - 1 and temp[j] == temp[j + 1]:  # 합칠 수 있는 경우
                    new_board[i][idx] = temp[j] * 2
                    temp[j + 1] = 0  # 다음 블록을 비움 (한 번 합치면 재합치기 방지)
                    idx += 1
                elif temp[j] != 0:  # 합치지 못한 경우 그대로 배치
                    new_board[i][idx] = temp[j]
                    idx += 1

    elif direction == 1:  # 오른쪽 이동
        for i in range(N):
            temp = [x for x in board[i] if x != 0]
            idx = N - 1
            for j in range(len(temp) - 1, -1, -1):
                if j > 0 and temp[j] == temp[j - 1]:  # 합칠 수 있는 경우
                    new_board[i][idx] = temp[j] * 2
                    temp[j - 1] = 0
                    idx -= 1
                elif temp[j] != 0:
                    new_board[i][idx] = temp[j]
                    idx -= 1

    elif direction == 2:  # 위쪽 이동
        for j in range(N):
            temp = [board[i][j] for i in range(N) if board[i][j] != 0]
            idx = 0
            for i in range(len(temp)):
                if i < len(temp) - 1 and temp[i] == temp[i + 1]:
                    new_board[idx][j] = temp[i] * 2
                    temp[i + 1] = 0
                    idx += 1
                elif temp[i] != 0:
                    new_board[idx][j] = temp[i]
                    idx += 1

    elif direction == 3:  # 아래쪽 이동
        for j in range(N):
            temp = [board[i][j] for i in range(N) if board[i][j] != 0]
            idx = N - 1
            for i in range(len(temp) - 1, -1, -1):
                if i > 0 and temp[i] == temp[i - 1]:
                    new_board[idx][j] = temp[i] * 2
                    temp[i - 1] = 0
                    idx -= 1
                elif temp[i] != 0:
                    new_board[idx][j] = temp[i]
                    idx -= 1

    return new_board

def dfs(n, arr):
    global ans
    ans = max(ans, max(map(max, arr)))  # 현재 최대값 업데이트

    if n == 5:
        return

    for i in range(4):
        new_board = move(arr, i)
        if new_board != arr:  # 이동이 발생한 경우에만 진행
            dfs(n + 1, new_board)

dfs(0, pan)
print(ans)
