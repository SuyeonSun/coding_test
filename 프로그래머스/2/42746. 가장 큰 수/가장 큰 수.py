import functools

def comparator(a,b):
    t1 = a+b # 두 문자열을 붙인 결과
    t2 = b+a # 반대로 붙인 결과
    
    if int(t1) > int(t2):
        return 1
    elif int(t1) == int(t2):
        return 0
    else:
        return -1

def solution(numbers):
    answer = ''
    
    n = []
    for number in numbers:
        n.append(str(number))
    n = sorted(n, key = functools.cmp_to_key(comparator), reverse = True)
    answer = str(int(''.join(n)))
    
    return answer