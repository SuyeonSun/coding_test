# 절댓값 
def solution(k, tangerine):
    answer = 0
    
    dict = {}
    
    def get_value(tan):
        return dict[tan]
    
    for tan in tangerine:
        if (tan not in dict.keys()):
            dict[tan] = 1
        else:
            dict[tan] += 1

    
    def get_value(tan):
        return dict[tan]
    
    new_dict = sorted(dict, key=get_value, reverse = True)
        
    for idx in new_dict:
        if k <= 0: 
            break
        k -= dict[idx]
        answer += 1
    
    return answer