from itertools import permutations
import math

def solution(numbers):
    primes = set()
    num_set = set()
    
    def is_prime(n):
        if n <= 1: # 소수는 1보다 큰 정수
            return False
        if n == 2:
            return True
        if n % 2 == 0:
            return False
        for i in range(3, int(math.sqrt(n)) + 1, 2):
            if n % i == 0:
                return False
        return True
    
    for i in range(1, len(numbers) + 1):
        for perm in permutations(numbers, i):
            num = int(''.join(perm))
            if num not in num_set:
                num_set.add(num)
                if is_prime(num):
                    primes.add(num)
                    
    return len(primes)
