nums = input().rstrip()  # 찾을 숫자 입력
current_number = 0  # 현재 자연수
current_idx = 0  # nums의 현재 인덱스

while True:
    current_number += 1
    for char in str(current_number):  # 현재 숫자를 문자열로 변환해 각 문자 비교
        if nums[current_idx] == char:
            current_idx += 1
            if current_idx == len(nums):  # nums의 모든 문자를 찾으면 출력 후 종료
                print(current_number)
                exit()
