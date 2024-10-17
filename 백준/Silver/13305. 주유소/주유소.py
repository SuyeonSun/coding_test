def min_cost_to_travel(n, distances, fuel_costs):
    total_cost = 0
    min_cost = fuel_costs[0]  # 첫 번째 도시에서 시작할 때의 기름 가격으로 초기화

    for i in range(n - 1):
        # 주유비용이 더 저렴한 도시가 있으면 갱신
        if fuel_costs[i] < min_cost:
            min_cost = fuel_costs[i]
        
        # 현재 도시에서 다음 도시까지의 거리만큼 주유
        total_cost += min_cost * distances[i]
    
    return total_cost

# 입력 처리
n = int(input())  # 도시의 개수
distances = list(map(int, input().split()))  # 도시간의 거리
fuel_costs = list(map(int, input().split()))  # 각 도시의 주유소 가격

# 최소 비용 계산
print(min_cost_to_travel(n, distances, fuel_costs))