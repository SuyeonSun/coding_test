from collections import Counter

def make_palindrome(input_string):
    char_count = Counter(input_string)
    odd_count = 0
    odd_char = ""
    half_palindrome = []
    
    # 홀수 문자의 개수를 확인
    for char, count in char_count.items():
        if count % 2 != 0:
            odd_count += 1
            odd_char = char
        # 홀수 문자가 두 개 이상일 경우 팰린드롬 불가
        if odd_count > 1:
            return "I'm Sorry Hansoo"
    
    # 팰린드롬의 절반을 생성 (사전순 정렬)
    for char in sorted(char_count.keys()):
        half_palindrome.append(char * (char_count[char] // 2))
    
    # 결과 조합
    first_half = "".join(half_palindrome)
    second_half = first_half[::-1]
    if odd_char:
        return first_half + odd_char + second_half
    else:
        return first_half + second_half

# 입력 처리
input_string = input().strip()
print(make_palindrome(input_string))
