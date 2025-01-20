import sys

n = int(sys.stdin.readline())
a = sorted(list(map(int, sys.stdin.readline().split(" "))))
x = int(sys.stdin.readline())
count = 0

left = 0
right = n-1

while left < right:
    temp = a[left] + a[right]
    if temp == x:
        count += 1
        left += 1
    elif temp > x:
        right -= 1
    else: left += 1

print(count)
