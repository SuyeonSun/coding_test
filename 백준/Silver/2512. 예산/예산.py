def find_max_budget(requests, total_budget):
    start, end = 0, max(requests)

    while start <= end:
        mid = (start + end) // 2

        # 예산을 계산하는 부분을 더 쉽게 작성
        allocated_budget = 0
        for req in requests:
            if req > mid:
                allocated_budget += mid
            else:
                allocated_budget += req

        if allocated_budget <= total_budget:
            start = mid + 1
        else:
            end = mid - 1

    return end

# 입력 처리
N = int(input())  # 지방의 수
requests = list(map(int, input().split()))  # 각 지방의 예산 요청
total_budget = int(input())  # 총 예산

# 예산 상한 출력
print(find_max_budget(requests, total_budget))
