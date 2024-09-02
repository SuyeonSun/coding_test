def solution(phone_book):
    answer = True
    
    hash_map = {}
    
    for phone_number in phone_book:
        hash_map[phone_number] = 1 # 같은 전화번호는 없음
    
    for phone_number in phone_book:
        temp = ""
        for number in phone_number:
            temp += number
            if temp in hash_map and temp != phone_number:
                answer = False
                
    return answer