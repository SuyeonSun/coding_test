from collections import deque

def solution(begin, target, words):
    answer = 0
    
    # 한 번에 한 개의 알파벳만 바꿀 수 있다.
    # words에 있는 단어로만 변환할 수 있다.
    
    def bfs():
        queue = deque()
        queue.append([begin, 0])
        while queue:
            now, step = queue.popleft()
            if now == target:
                return step
            for word in words:
                count = 0
                for i in range(len(now)):
                    if now[i] != word[i]:
                        count += 1
                if count == 1:
                    queue.append([word, step + 1])
    
    if target not in words:
        return 0
    
    answer = bfs()
    return answer