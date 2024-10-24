from collections import deque

def solution(people, limit):
    answer = 0
    
    people = deque(sorted(people))
    
    while True:
        if not people:
            break
        person = people.pop()
        if len(people) > 0 and people[0] + person <= limit:
            people.popleft()
        answer += 1
    
    
    
    return answer