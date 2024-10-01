import heapq

def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    
    while scoville:
        if scoville[0] >= K:
            return answer
        first = heapq.heappop(scoville)
        if not scoville:
            return -1
        second = heapq.heappop(scoville)
        mixed = first + (second * 2)
        heapq.heappush(scoville, mixed)
        answer += 1
        
    
    return answer