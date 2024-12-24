import heapq
import sys
input = sys.stdin.readline  # 빠른 입력 함수 사용

heap = []
n = int(input())
for _ in range(n):
    x = int(input())
    if x == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(-heapq.heappop(heap))
    else:
        heapq.heappush(heap, -x)
