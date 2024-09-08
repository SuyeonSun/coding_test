def solution(n, words):
    answer = []
    
    
    # % 번째
    # // 차례
    said_words = set()
    
    def is_valid(idx):
        word = words[idx]
        if word in said_words:
            return False
        if words[idx - 1][-1] != word[0]:
            return False
        said_words.add(words[idx])
        return True    
    
    for i in range(len(words)):
        if i == 0:
            said_words.add(words[i])
            continue
        if is_valid(i) == False:
            answer = [i % n + 1, i // n + 1]
            return answer
    
    if len(answer) == 0:
        answer = [0, 0]
        
    return answer