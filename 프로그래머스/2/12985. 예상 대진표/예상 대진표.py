def solution(n,a,b):
    answer = 0

    round = 0
    
    while a != b:
        round += 1
        a = (a + 1) // 2
        b = (b + 1) // 2
    
    answer = round 
    
    return answer