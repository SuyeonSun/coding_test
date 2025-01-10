N, C, W = map(int, input().split())  # 나무 개수, 톱질 비용, 판자 판매 가격
trees = [int(input()) for _ in range(N)]  # 나무 길이들

max_length = max(trees)  # 가장 긴 나무의 길이
max_profit = 0

# 가능한 자르는 길이 k를 1부터 최대 길이까지 시도
for k in range(1, max_length + 1):
    total_profit = 0

    for length in trees:
        # k로 잘라 얻을 수 있는 판자 개수
        count = length // k
        # 잘라야 할 톱질 횟수
        cuts = count - 1 if length % k == 0 else count
        # 이익 계산
        profit = count * k * W - cuts * C

        if profit > 0:  # 이익이 양수인 경우만 더함
            total_profit += profit

    max_profit = max(max_profit, total_profit)

print(max_profit)