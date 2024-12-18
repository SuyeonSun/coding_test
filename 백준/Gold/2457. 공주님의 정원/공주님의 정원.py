def princess_garden():
    import sys
    input = sys.stdin.read
    data = input().splitlines()
    
    n = int(data[0])  # 꽃의 개수
    flowers = []
    
    for i in range(1, n + 1):
        sm, sd, em, ed = map(int, data[i].split())
        flowers.append((sm * 100 + sd, em * 100 + ed))
    
    # 꽃을 시작 날짜로 정렬, 같은 시작 날짜라면 끝나는 날짜로 내림차순 정렬
    flowers.sort(key=lambda x: (x[0], -x[1]))
    
    current_end = 301  # 3월 1일부터 시작
    max_end = 301
    count = 0
    i = 0
    
    while current_end <= 1130:
        found = False
        while i < n and flowers[i][0] <= current_end:
            max_end = max(max_end, flowers[i][1])
            i += 1
            found = True
        
        if not found:
            print(0)
            return
        
        count += 1
        current_end = max_end
    
    print(count)

# 실행 예시
# 표준 입력이 제공될 경우 사용합니다.
princess_garden()
