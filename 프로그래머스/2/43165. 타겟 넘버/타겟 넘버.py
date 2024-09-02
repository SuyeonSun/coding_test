def solution(numbers, target):
    global answer
    answer = 0
    
    def dfs(numbers, target, total, index):
        global answer

        if index > len(numbers) - 1:
            if total == target:
                answer += 1
            return
        
        dfs(numbers, target, total + numbers[index], index + 1)
        dfs(numbers, target, total - numbers[index], index + 1)
        
    dfs(numbers, target, 0, 0)
    
    
    return answer