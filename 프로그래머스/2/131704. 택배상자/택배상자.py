def solution(order):
    answer = 0
    
    main = list(range(1, len(order) + 1))  # 메인 컨베이어 벨트
    sub = []  # 보조 컨베이어 벨트 (스택)
    truck = []  # 트럭에 실린 상자들
    
    order_index = 0  # 주문 순서를 확인하는 인덱스
    
    for box in main:
        if order_index >= len(order):
            break
        
        if order[order_index] == box:
            truck.append(box)
            order_index += 1
        else:
            sub.append(box)
        
        while sub and order_index < len(order) and sub[-1] == order[order_index]:
            truck.append(sub.pop())
            order_index += 1
    
    return len(truck)