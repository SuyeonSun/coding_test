def solution(data, col, row_begin, row_end):
    # 1. 주어진 col번째 컬럼을 기준으로 오름차순 정렬
    # 2. col 값이 같다면 첫 번째 컬럼(기본키)을 기준으로 내림차순 정렬
    data.sort(key=lambda x: (x[col - 1], -x[0]))

    result = 0
    
    # 3. row_begin부터 row_end까지 S_i 값을 계산하고 XOR 연산 수행
    for i in range(row_begin, row_end + 1):
        row = data[i - 1]  # 0-based 인덱스를 사용하므로 i - 1
        S_i = sum([x % i for x in row])  # 각 원소를 i로 나눈 나머지의 합
        result ^= S_i  # XOR 연산

    return result
