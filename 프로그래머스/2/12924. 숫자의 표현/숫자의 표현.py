def solution(n):
    answer = 0
    
    m = 1
    while(True):
        if (m > n):
            break
        
        idx = m
        total = 0
        while(True):
            if (total > n):
                break
            if (total == n):
                answer += 1
                break
            total += idx
            idx += 1
        
        m += 1
    
    return answer