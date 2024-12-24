import sys
import heapq

input = sys.stdin.read  # 빠른 입력
data = input().split()

heap = []
n = int(data[0])  # 첫 번째 입력값: 명령 개수

for x in map(int, data[1:]):
    if x == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap))
    else:
        heapq.heappush(heap, x)
