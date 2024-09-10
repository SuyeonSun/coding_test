import heapq

def time_to_minutes(time_str):
    """ Converts HH:MM time format to minutes since midnight. """
    hours, minutes = map(int, time_str.split(':'))
    return hours * 60 + minutes

def solution(book_time):
    # Convert time strings to minutes and sort by start time
    events = []
    for start, end in book_time:
        start_time = time_to_minutes(start)
        end_time = time_to_minutes(end) + 10  # Adding 10 minutes for cleaning
        events.append((start_time, end_time))
    
    events.sort()  # Sort by start time
    
    # Min-heap to track end times of rooms
    heap = []
    
    for start, end in events:
        # Check if the earliest ending room can be reused
        if heap and heap[0] <= start:
            heapq.heappop(heap)  # Remove the room that is done cleaning
        
        # Allocate a new room or reuse the existing one
        heapq.heappush(heap, end)
    
    # The size of the heap is the number of rooms needed
    return len(heap)