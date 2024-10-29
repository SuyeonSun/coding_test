import heapq

def solution(operations):
    max_heap = []
    min_heap = []
    
    for operation in operations:
        if operation == "D 1":
            # 최대값 삭제
            if max_heap:
                max_value = -heapq.heappop(max_heap)
                # min_heap에서 최대값도 삭제
                min_heap.remove(max_value)
                heapq.heapify(min_heap)  # 삭제 후 힙 재구성
        elif operation == "D -1":
            # 최소값 삭제
            if min_heap:
                min_value = heapq.heappop(min_heap)
                # max_heap에서 최소값도 삭제
                max_heap.remove(-min_value)
                heapq.heapify(max_heap)  # 삭제 후 힙 재구성
        else:
            # 삽입 연산
            num = int(operation[2:])
            heapq.heappush(max_heap, -num)
            heapq.heappush(min_heap, num)
    
    # 힙이 비어 있는 경우 [0, 0] 반환
    if not min_heap:
        return [0, 0]
    
    # 최종 최대값, 최소값을 answer로 반환
    return [-max_heap[0], min_heap[0]]