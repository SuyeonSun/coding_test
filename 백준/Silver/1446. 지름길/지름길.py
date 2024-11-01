import heapq

# 입력 처리
n, d = map(int, input().split())
shortcuts = []

for _ in range(n):
    start, end, length = map(int, input().split())
    if end <= d:  # 목적지를 넘어서는 지름길은 무시
        shortcuts.append((start, end, length))

# 최단 거리 배열 초기화
dist = [i for i in range(d + 1)]

# 다익스트라 알고리즘
for i in range(d + 1):
    if i > 0:
        dist[i] = min(dist[i], dist[i - 1] + 1)  # 한 칸 이동 시 비용 추가

    for start, end, length in shortcuts:
        if i == start and dist[start] + length < dist[end]:
            dist[end] = dist[start] + length

# 결과 출력
print(dist[d])