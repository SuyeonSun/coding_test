def solution(n, words):
    answer = []

    # [가장 먼저 탈락하는 사람의 번호, 그 사람이 자신의 몇 번째 차례에 탈락하는지]
    # [0, 0]
    
    # 끝 글자가 맞지 않거나
    # 같은 글자를 반복하거나
    
    said_words = [words[0]]
    turn = 2
    
    for i in range(1, len(words)):
        if (turn > n):
            turn = 1
        if (words[i] not in said_words and said_words[-1][-1] == words[i][0]):
            said_words.append(words[i])
            turn += 1
        else:
            print(turn)
            if ((i+1) % n != 0):
                answer = [turn, (i+1) // n + 1]
            else:
                answer = [turn, (i+1) // n]
            break   
    
    if (len(answer) == 0):
        answer = [0, 0]
        
    return answer