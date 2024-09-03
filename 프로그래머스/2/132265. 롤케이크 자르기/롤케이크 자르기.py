from collections import Counter

def solution(topping):
    answer = 0
    
    left = set()                # 중복 제거를 위해 set으로 만들어줌
    right = Counter(topping)    # right는 Counter로 만들어 토핑의 개수 파악
    
    for t in topping:
        left.add(t)             # left에 토핑 하나 추가
        right[t] -= 1           # right에서 해당 토핑 개수 -1
        
        # 토핑을 옮긴 후 해당 토핑이 더 이상 right에 없으면(=0개이면) 제거
        if right[t] == 0: 
            del right[t]
            
        # left와 right의 토핑 개수가 같으면
        if len(left) == len(right):
            answer += 1
            
    return answer