def solution(want, number, discount):
    answer = 0
    
    dict = {}
    for i in range(len(want)):
        dict[want[i]] = number[i]
    
    for i in range(len(discount) - 9):
        dict_copy = dict.copy()
        for j in range(i, i + 10):
            if discount[j] in dict_copy and dict_copy[discount[j]] > 0:
                dict_copy[discount[j]] -= 1
            else:
                break
        if sum(dict_copy.values()) == 0:
            answer += 1
    
    return answer