import heapq

def solution(scoville, K):
    answer = 0
    
    # 힙으로 변환(최소 힙)
    heapq.heapify(scoville)
    
    while scoville:
        if scoville[0] >= K:
            return answer
                
        first = heapq.heappop(scoville)
        
        # 두번째 원소를 꺼낼 수 없다면
        if not scoville:
            return -1
            
        second = heapq.heappop(scoville)
        mixed_scoville = first + (second * 2)
        heapq.heappush(scoville, mixed_scoville)
        answer += 1
        
    return answer