from itertools import combinations

def calculate_chicken_distance(houses, chicken_shops):
    total_distance = 0
    for hx, hy in houses:
        min_distance = float('inf')
        for cx, cy in chicken_shops:
            min_distance = min(min_distance, abs(hx - cx) + abs(hy - cy))
        total_distance += min_distance
    return total_distance

def solve_chicken_delivery(n, m, city):
    houses = []
    chicken_shops = []

    # 집과 치킨집의 위치 저장
    for i in range(n):
        for j in range(n):
            if city[i][j] == 1:
                houses.append((i, j))
            elif city[i][j] == 2:
                chicken_shops.append((i, j))

    min_city_distance = float('inf')
    
    # M개의 치킨집을 선택하는 조합을 생성
    for selected_chickens in combinations(chicken_shops, m):
        city_distance = calculate_chicken_distance(houses, selected_chickens)
        min_city_distance = min(min_city_distance, city_distance)

    return min_city_distance

# 입력 처리
n, m = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(n)]

# 결과 출력
print(solve_chicken_delivery(n, m, city))
