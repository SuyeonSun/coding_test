import heapq

def solution(scoville, K):
    answer = 0
    
    # 가장 작은 순서대로 pop이 필요하기 때문에 min heap 사용
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