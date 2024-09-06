def solution(arr):
    answer = [0, 0]
    
    def comparession(a, b, l):
        start = arr[a][b]
        for i in range(a, a+l):
            for j in range(b, b+l):
                if arr[i][j] != start:  # arr[i][j]가 처음 값과 다르면 압축 불가능 # 핵심
                    l = l // 2
                    comparession(a, b, l)
                    comparession(a, b + l, l)
                    comparession(a + l, b, l)
                    comparession(a + l, b + l, l)
                    return # 압축이 불가능 하면 종료
        # 압축이 가능할 때, 해당 값을 count
        answer[start] += 1
        
        
    comparession(0,0,len(arr))
    
    return answer