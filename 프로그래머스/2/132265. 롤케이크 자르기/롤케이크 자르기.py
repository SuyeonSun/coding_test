from collections import Counter

def solution(topping):
    answer = 0
    
    # 핵심: 한쪽에 모두 몰아넣고 시작
    left = set()
    right = Counter(topping) # 딕셔너리 반환
    
    for t in topping:
        left.add(t) # set은 add()
        right[t] -= 1
        
        if right[t] == 0:
            del right[t] # dictionary 요소 삭제

        if len(left) == len(right):
            answer += 1
            
    return answer