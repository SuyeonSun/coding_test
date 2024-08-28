def solution(n):
    answer = 0
    
    array = [0, 1]
    
    idx = 2
    
    while (True):
        if (idx > n):
            break
        array.append((array[idx-1] + array[idx-2]) % 1234567)
        idx += 1
    
    answer = array[-1]
    return answer