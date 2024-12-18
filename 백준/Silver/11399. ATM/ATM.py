# [3, 1, 4, 3, 2]

# [3, 1, 4, 3, 2] [3, 4, 8, 11, 13] 39
# [1, 2, 3, 3, 4] [1, 3, 6, 9, 13] 32

N = int(input())
arr = list(map(int, input().split()))
arr.sort()
for i in range(1, len(arr)):
    arr[i] += arr[i-1]
print(sum(arr))