import math

def solution(arrayA, arrayB):
    answer = 0
    
    # 최대공약수 math.gcd
    gcd_a = arrayA[0]
    gcd_b = arrayB[0]

    for i in range(1, len(arrayA)):
        gcd_a = math.gcd(gcd_a, arrayA[i])
        gcd_b = math.gcd(gcd_b, arrayB[i])
    
    def is_valid(gcd_val, opponent_array):
        for i in opponent_array:
            if i % gcd_val == 0:
                return False
        return True
    
    if is_valid(gcd_a, arrayB):
        answer = max(answer, gcd_a)
    if is_valid(gcd_b, arrayA):
        answer = max(answer, gcd_b)
    
    return answer