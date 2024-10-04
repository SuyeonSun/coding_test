word = input().upper()
count_dict = {}

# 각 문자의 빈도를 딕셔너리에 저장
for char in word:
    if char in count_dict:
        count_dict[char] += 1
    else:
        count_dict[char] = 1

# 최대 빈도 값 찾기
max_count = max(count_dict.values())

# 최대 빈도를 가진 문자 개수 확인
max_chars = []
for char, count in count_dict.items():
    if count == max_count:
        max_chars.append(char)
        
# 결과 출력
if len(max_chars) > 1:
    print("?")
else:
    print(max_chars[0])
