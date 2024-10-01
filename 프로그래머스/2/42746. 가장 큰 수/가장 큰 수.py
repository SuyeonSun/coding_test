import functools

def comparator(a, b):
    n1 = a + b
    n2 = b + a
    if int(n1) > int(n2):
        return 1
    elif int(n1) == int(n2):
        return 0
    else:
        return -1

def solution(numbers):
    answer = ''
    max_val = 0
    
    n = []
    for num in numbers:
        n.append(str(num))
    
    n = sorted(n, key = functools.cmp_to_key(comparator), reverse = True)
    
    answer = str(int(''.join(n)))
    
    return answer