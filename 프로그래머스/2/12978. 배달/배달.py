import heapq

def solution(N, road, K):
    answer = 0

    dist = [float('inf')] * (N + 1)
    dist[1] = 0
    adj = [[] for _ in range(N + 1)]
    
    def dijkstra(dist, adj):
        heap = []
        heapq.heappush(heap, [1, 0])
        while heap:
            node, cost = heapq.heappop(heap)
            for n, c in adj[node]:
                if cost + c < dist[n]:
                    dist[n] = cost + c
                    heapq.heappush(heap, [n, cost + c])

    for r in road:
        adj[r[0]].append([r[1], r[2]])
        adj[r[1]].append([r[0], r[2]])
    
    dijkstra(dist, adj)
    
    for i in dist:
        if i <= K:
            answer += 1
    
    
    return answer