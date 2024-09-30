def solution(numbers, target):
    global answer
    answer = 0
    
    def dfs(idx, cnt, total):
        global answer 
        
        if cnt == len(numbers):
            if total == target:
                answer += 1
            return
        dfs(idx + 1, cnt + 1, total + numbers[idx])
        dfs(idx + 1, cnt + 1, total - numbers[idx])
    
    dfs(0, 0, 0)
    
    return answer