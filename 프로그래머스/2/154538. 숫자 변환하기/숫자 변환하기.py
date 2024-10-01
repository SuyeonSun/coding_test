from collections import deque 

def solution(x, y, n):
    answer = -1
    
    visited = [False] * 10000001
    
    q = deque()
    q.append([x, 0])
    visited[x] = True
    
    while q:
        num, cnt = q.popleft()
        if num == y:
            return cnt
        next_nums = [num + n, num * 2, num * 3]
        for next_num in next_nums:
            if next_num <= y and not visited[next_num]:
                visited[next_num] = True
                q.append([next_num, cnt + 1])
    
    return answer