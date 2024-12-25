N = int(input())
arr = list(map(int, input().split()))
result = []

# 큰 사람부터 처리 (뒤에서부터 삽입)
for i in range(N):
    # 각 사람을 올바른 위치에 삽입
    result.insert(arr[N - 1 - i], N - i)

print(*result)
