n = int(input())
arr = list(map(int, input().split()))
x = int(input())
count = 0

arr.sort()

left = 0
right = n - 1

while left < right:
    temp = arr[left] + arr[right]
    if temp == x:
        count += 1
        left += 1
    elif temp > x:
        right -= 1
    else:
        left += 1

print(count)