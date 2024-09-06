from itertools import permutations
import math

def solution(numbers):
    answer = []
    
    def is_prime(n):
        if n == 0 or n == 1: # 소수는 1보다 큰 정수
            return False
        else:
            for i in range(2, int(math.sqrt(n))+1):
                if n % i == 0:
                    return False
            return True
    
    for i in range(1, len(numbers)+1):
        arr = list(permutations(numbers, i)) # permutations(numbers, i) 이것만 하면, ('1', '7') 이렇게 튜플 형태로 반환되기 때문이다.
        for j in range(len(arr)):
            num = int(''.join(map(str,arr[j])))
            if is_prime(num):
                answer.append(num)
                
    answer=list(set(answer))
    return len(answer)