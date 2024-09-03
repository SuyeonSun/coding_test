def solution(word):
    answer = 0
    
    words = ['A', 'E', 'I', 'O', 'U']
    word_list = []
    
    def make_word(cnt, w):
        if cnt == 5:
            return
        for i in range(5):
            new_word = w + words[i]
            word_list.append(new_word)
            make_word(cnt + 1,new_word)
    
    make_word(0, "")
    
    answer = word_list.index(word) + 1
    
    return answer