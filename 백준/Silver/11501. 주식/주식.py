N = int(input())
for _ in range(N):
    n = int(input())
    arr = list(map(int, input().split()))

    max_price = 0
    profit = 0

    # 뒤에서부터 탐색하며 최대값 갱신
    for price in reversed(arr):
        if price > max_price:
            max_price = price
        else:
            profit += max_price - price

    print(profit)
