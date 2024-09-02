from collections import deque

def solution(priorities, location):
    answer = 0
    
    queue = deque()
    for i in range(len(priorities)):
        queue.append([priorities[i], i])
    
    result = []
        
    while len(queue) > 0:
        flag = True
        for i in range(1, len(queue)):
            if queue[0][0] < queue[i][0]:
                flag = False
                break
        if flag == False:
            poll = queue.popleft()
            queue.append(poll)
        else:
            poll = queue.popleft()
            result.append(poll)
    
    for i in range(len(result)):
        if result[i][1] == location:
            answer = i+1
            break
            
    return answer