import math

def solution(n, k):
    # 1 ~ n까지의 숫자 목록
    numbers = list(range(1, n+1))
    answer = []
    
    # 각 자리에 어떤 숫자가 올지 결정하는 과정
    while n > 0:
        n -= 1
        
        # 현재 자리에서 결정해야 하는 숫자의 그룹 크기 (n-1)!
        fact = math.factorial(n)
        
        # k에 대한 1-based index를 사용하므로 (k-1)을 그대로 사용하지 않고 k로 나눈다
        index = (k - 1) // fact
        
        # 해당 index에 있는 숫자를 answer에 추가
        answer.append(numbers.pop(index))
        
        # k 값을 (n-1)!로 나눈 나머지로 갱신
        k = k % fact
    
    return answer
