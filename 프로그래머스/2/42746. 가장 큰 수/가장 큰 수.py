import functools

def comparator(a,b):
    t1 = a+b # 두 문자열을 붙인 결과
    t2 = b+a # 반대로 붙인 결과
    return (int(t1) > int(t2)) - (int(t1) < int(t2)) #  t1이 크다면 1 반환 // t2가 크다면 -1 반환  //  같으면 0 반환

def solution(numbers):
    n = [str(x) for x in numbers]
    n = sorted(n, key=functools.cmp_to_key(comparator),reverse=True)
    answer = str(int(''.join(n)))
    return answer