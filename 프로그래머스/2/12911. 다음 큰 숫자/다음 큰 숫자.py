def solution(n):
    answer = 0
    
    binary_n_cnt = bin(n)[2:].count("1")
    
    while(True):
        n += 1
        new_binary_n_cnt = bin(n)[2:].count("1")
        if (binary_n_cnt == new_binary_n_cnt):
            break
    answer = n
    
    return answer