from collections import deque

def solution(n, wires):
    answer = 101
    graph = [[] for i in range(n+1)]
    
    def bfs(start):
        visited = [False] * (n+1)
        queue = deque([start])
        visited[start] = True
        cnt = 1
        while queue:
            pop = queue.popleft()
            for i in graph[pop]:
                if not visited[i]:
                    queue.append(i)
                    visited[i] = True
                    cnt += 1
        return cnt
    
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)
    
    for a, b in wires:
        graph[a].remove(b)
        graph[b].remove(a)
        
        answer = min(abs(bfs(a) - bfs(b)), answer)
        
        graph[a].append(b)
        graph[b].append(a)
    
    return answer