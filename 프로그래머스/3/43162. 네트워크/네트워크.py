from collections import deque

def solution(n, computers):
    answer = 0
    visited = [False for _ in range(n)]
    
    def bfs(i):
        queue = deque([i])
        visited[i] = True  # 방문 처리

        while queue:
            x = queue.popleft()
            for j in range(n):  # 모든 노드를 확인
                if computers[x][j] == 1 and not visited[j]:  # 연결되어 있고 방문하지 않았다면
                    visited[j] = True
                    queue.append(j)

    for i in range(n):
        if not visited[i]:  # 방문하지 않은 노드라면 새로운 네트워크 발견
            bfs(i)
            answer += 1  # 새로운 네트워크 개수 증가
    
    return answer
