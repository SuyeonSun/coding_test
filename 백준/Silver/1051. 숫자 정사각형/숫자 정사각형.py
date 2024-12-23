n, m = map(int, input().split())
matrix = [list(input()) for _ in range(n)]

# 초기화
max_size = 1  # 최소 정사각형 크기

# 탐색
for i in range(n):
    for j in range(m):
        for size in range(1, min(n - i, m - j)):
            if (matrix[i][j] == matrix[i + size][j] == matrix[i][j + size] == matrix[i + size][j + size]):
                max_size = max(max_size, size + 1)

# 결과 출력 (정사각형의 넓이)
print(max_size ** 2)