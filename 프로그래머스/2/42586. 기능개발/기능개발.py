def solution(progresses, speeds):
    answer = []
    
    days = []
    for i in range(len(progresses)):
        m = (100 - progresses[i]) // speeds[i]
        n = (100 - progresses[i]) % speeds[i]
        if n != 0:
            m += 1
        days.append(m)  # 각 기능별 완료 일수 리스트
    
    current = days[0]
    count = 0
    
    for day in days:
        if day <= current:
            count += 1
        else:
            answer.append(count)
            current = day
            count = 1
            
    answer.append(count)
    
    return answer