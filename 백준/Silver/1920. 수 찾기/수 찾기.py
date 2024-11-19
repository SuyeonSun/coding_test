def binary_search(array, target):
    left, right = 0, len(array) - 1
    while left <= right:
        mid = (left + right) // 2
        if array[mid] == target:
            return True
        elif array[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return False

# 입력
n = int(input())
A = list(map(int, input().split()))
m = int(input())
queries = list(map(int, input().split()))

# 정렬
A.sort()

# 각 쿼리 확인
result = []
for x in queries:
    if binary_search(A, x):
        result.append(1)
    else:
        result.append(0)

# 출력
print("\n".join(map(str, result)))
