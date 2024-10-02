def solution(sequence, k):
    answer = []
    
    start, end = 0, 0
    partial_sum = sequence[0]
    min_length = float("inf")
    
    while end < len(sequence):
        if partial_sum == k:
            length = end - start + 1
            if length < min_length:
                min_length = length
                answer = [start, end]
            partial_sum -= sequence[start]
            start += 1
        elif partial_sum < k:
            end += 1
            if end < len(sequence):
                partial_sum += sequence[end]
        else:
            partial_sum -= sequence[start]
            start += 1
    return answer