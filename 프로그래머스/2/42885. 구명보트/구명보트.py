from collections import deque

def solution(people, limit):
    answer = 0

    people = deque(sorted(people)) # deque 사용 시에는, sort() 메서드는 사용할 수 없고, sorted()만 사용 가능
    
    while True:
        if not people:  # people이 비어있다면 루프를 종료
            break
            
        person = people.pop()
        if (len(people) > 0 and person + people[0] <= limit):
            people.popleft()
        answer += 1
    
    return answer