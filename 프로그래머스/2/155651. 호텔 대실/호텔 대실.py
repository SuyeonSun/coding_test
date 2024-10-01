import heapq

def solution(book_time):
    answer = 0
    
    def hour_to_min(time_str):
        hours, minutes = map(int, time_str.split(":"))
        return hours * 60 + minutes
    
    events = []
    for s, e in book_time:
        start = hour_to_min(s)
        end = hour_to_min(e) + 10
        events.append([start, end])
    
    events.sort()
    
    heap = []
    for start, end in events:
        if heap and heap[0] <= start:
            heapq.heappop(heap)
        heapq.heappush(heap, end)
    
    answer = len(heap)
    return answer