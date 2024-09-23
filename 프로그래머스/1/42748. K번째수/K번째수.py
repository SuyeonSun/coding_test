def solution(array, commands):
    answer = []
    
    for command in commands:
        new_array = array[command[0]-1: command[1]]  # 슬라이싱으로 배열을 자름
        new_array.sort()  # 정렬, 반환값이 None이 아님
        answer.append(new_array[command[2] - 1]) # 정렬된 리스트 출력
    
    return answer
