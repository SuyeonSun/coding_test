import heapq

N = int(input())
heap = []
for i in range(N):
    numbers = list(map(int, input().split()))
    for n in numbers:
        if len(heap) < N:
            heapq.heappush(heap, n)
        elif n > heap[0]:
            heapq.heappop(heap)
            heapq.heappush(heap, n)

print(heap[0])