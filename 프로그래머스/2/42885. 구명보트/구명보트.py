from collections import deque

def solution(people, limit):
    answer = 0
    
    people = deque(sorted(people, reverse = True))
    
    while people:
        person = people.popleft()
        if people and person + people[-1] <= limit:
            people.pop()
        answer += 1
    
    return answer