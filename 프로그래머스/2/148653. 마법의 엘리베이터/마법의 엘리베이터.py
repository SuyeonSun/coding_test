def solution(storey):
    magic_stones = 0  # 필요한 마법의 돌 개수
    while storey > 0:
        current_digit = storey % 10  # 현재 자리의 숫자
        if current_digit > 5:
            magic_stones += (10 - current_digit)  # 올림
            storey = (storey // 10) + 1
        elif current_digit == 5 and (storey // 10) % 10 >= 5:
            # 5인 경우 다음 자릿수가 5 이상이면 올림
            magic_stones += 5
            storey = (storey // 10) + 1
        else:
            magic_stones += current_digit  # 버림
            storey //= 10
    return magic_stones