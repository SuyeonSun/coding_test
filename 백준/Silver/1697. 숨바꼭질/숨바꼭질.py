from collections import deque

def bfs(N, K):
    MAX = 100001
    visited = [False] * MAX
    queue = deque()
    
    queue.append((N, 0))  # (현재 위치, 시간)
    visited[N] = True
    
    while queue:
        pos, time = queue.popleft()
        
        if pos == K:
            return time  # 동생을 찾으면 시간 반환
        
        # 다음 이동할 수 있는 위치들
        for next_pos in (pos - 1, pos + 1, pos * 2):
            if 0 <= next_pos < MAX and not visited[next_pos]:
                visited[next_pos] = True
                queue.append((next_pos, time + 1))

# 입력
N, K = map(int, input().split())
print(bfs(N, K))
