import heapq

def time_to_minute(time_str):
    hours, minutes = map(int, time_str.split(":"))
    return hours * 60 + minutes
    
def solution(book_time):
    answer = 0
    
    events = []
    
    for start, end in book_time:
        start_time = time_to_minute(start)
        end_time = time_to_minute(end) + 10
        events.append([start_time, end_time])
    
    events.sort()
    
    heap = []
    
    for start, end in events:
        if heap and heap[0] <= start:   
            heapq.heappop(heap)
        heapq.heappush(heap, end)
    
    answer = len(heap)
    
    return answer