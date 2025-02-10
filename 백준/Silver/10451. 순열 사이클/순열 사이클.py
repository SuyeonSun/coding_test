from collections import deque
import sys

def bfs(start):
    queue = deque([start])
    visited[start] = True

    while queue:
        node = queue.popleft()
        next_node = permutation[node]
        if not visited[next_node]:
            visited[next_node] = True
            queue.append(next_node)

def count_cycles(n, permutation):
    global visited
    visited = [False] * (n + 1)
    cycle_count = 0

    for i in range(1, n + 1):
        if not visited[i]:  # 방문하지 않은 노드라면 새로운 사이클 시작
            bfs(i)
            cycle_count += 1  # BFS 종료 후 하나의 사이클이 완성됨

    return cycle_count

# 입력 처리
t = int(sys.stdin.readline().strip())  # 테스트 케이스 개수

for _ in range(t):
    n = int(sys.stdin.readline().strip())  # 순열 크기
    permutation = [0] + list(map(int, sys.stdin.readline().split()))  # 인덱스 1부터 시작하도록 0 추가
    print(count_cycles(n, permutation))
