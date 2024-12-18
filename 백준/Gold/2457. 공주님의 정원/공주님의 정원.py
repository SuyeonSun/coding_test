n = int(input())
date = []
# 편의를 위해 100을 곱해 날짜 형식으로 바꿈
for i in range(n):
    temp = list(map(int, input().split())) # 1 1 5 31
    date.append([temp[0] * 100 + temp[1], temp[2] * 100 + temp[3]])

# 꽃이 피고 지는 날짜를 오름차순으로 정렬
date.sort(key = lambda x: (x[0], x[1])) 
# [[101, 531], [101, 630], [515, 831], [610, 1210]]

# 선택한 꽃의 개수
cnt = 0
# 제일 늦게 지는 꽃을 비교
end = 0
# 마지막 꽃이 지는 날
target = 301

# 모든 꽃이 없어질 때까지 반복하여 꽃을 비교
while date:
    # 마지막 꽃이 지는 날이 12월1일보다 크거나 같을때
    # 마지막 꽃이 지는날이 제일 빨리 피는 꽃보다 작을때
    if target >= 1201 or target < date[0][0]:
        break
    
    # 꽃 개수의 길이만큼 반복하여 구간별로 꽃을 비교
    for _ in range(len(date)):
        # 마지막 꽃의 지는 날이 제일 빨리 피는 꽃보다 크거나 같으면 제일 빨리 피는 꽃의 지는 날을 확인
        if target >= date[0][0]:
            # 그 꽃의 지는 날과 마지막으로 꽃의 지는 날을 비교한다.
            # 그 꽃의 지는 날이 더 크면 더 오래 꽃을 볼 수 있기 때문에
            # 그 꽃의 지는 날을 마지막 꽃의 지는 날로 변경
            if end <= date[0][1]:
                end = date[0][1]
            
            # 꽃을 확인하면 지운다.
            date.remove(date[0])
        # 꽃이 지는 날이 제일 빨리 피는 꽃보다 작으면 멈춘다.
        else:
            break
    target = end
    cnt += 1

# 마지막 꽃의 지는 날이 12월 1일보다 작으면 11월 30일에는 피어있는 꽃이 없기때문에 0을 출력
if target < 1201:
    print(0)
else:
    print(cnt)