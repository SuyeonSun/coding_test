import functools

def solution(numbers):
    answer = ''
    
    # 문자열로 변환
    # 두 수를 가장 크게 정렬
    
    array = []
    for number in numbers:
        array.append(str(number))
    
    def comparator(a, b):
        w1 = int(a + b)
        w2 = int(b + a)
        if w1 > w2:
            return 1
        elif w1 == w2:
            return 0
        else:
            return -1
        
    array = sorted(array, key = functools.cmp_to_key(comparator), reverse = True)
    answer = str(int("".join(array)))
    
    
    return answer