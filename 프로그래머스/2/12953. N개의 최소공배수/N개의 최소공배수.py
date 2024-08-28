from math import gcd

def solution(arr):
    answer = 0
    
    answer = arr[0]
    for i in range(1, len(arr)):
        answer = (answer*arr[i]) // gcd(answer, arr[i])
    return answer
    
    return answer