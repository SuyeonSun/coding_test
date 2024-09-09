def solution(sequence, k):
    answer = []
    start, end = 0, 0
    current_sum = sequence[0]
    min_length = float('inf')
    
    while end < len(sequence): # 끝 포인터가 배열을 벗어나지 않는 동안 반복
        if current_sum == k:
            length = end - start + 1
            if length < min_length:
                min_length = length
                answer = [start, end]
            current_sum -= sequence[start] # 시작 포인터 이동하여 구간 축소
            start += 1
        
        elif current_sum < k:
            end += 1
            if end < len(sequence):
                current_sum += sequence[end]
        
        else:
            current_sum -= sequence[start]
            start += 1
    
    return answer