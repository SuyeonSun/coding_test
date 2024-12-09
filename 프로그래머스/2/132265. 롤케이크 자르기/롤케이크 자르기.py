from collections import Counter

def solution(topping):
    answer = 0
    
    left_counter = Counter()
    right_counter = Counter(topping)
    
    for t in topping:
        left_counter[t] += 1
        right_counter[t] -= 1
        
        if right_counter[t] == 0:
            del right_counter[t]
        
        if len(left_counter) == len(right_counter):
            answer += 1
            
    return answer