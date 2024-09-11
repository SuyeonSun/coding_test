import heapq

def dijkstra(dist, adj):
    heap = []
    heapq.heappush(heap, [1, 0]) # 노드, 거리
    while heap:
        node, cost = heapq.heappop(heap)
        for n, c in adj[node]:
            if cost + c < dist[n]:
                dist[n] = cost + c
                heapq.heappush(heap, [n, cost + c])
    
def solution(N, road, K):
    answer = 0

    dist = [float('inf')] * (N + 1)
    dist[1] = 0 # 1번은 자기 자신이기 때문에 거리를 0
    adj = [[] for _ in range(N + 1)] # 인접 노드와 거리를 기록할 배열 # 무조건 이렇게 이중배열 선언! *로 하면 값이 이상하게 들어감
    
    for r in road:
        adj[r[0]].append([r[1], r[2]])
        adj[r[1]].append([r[0], r[2]])
        
    dijkstra(dist, adj)
    
    for i in dist:
        if i <= K:
            answer += 1

    return answer