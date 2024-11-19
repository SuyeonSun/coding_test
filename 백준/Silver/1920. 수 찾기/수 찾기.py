N = int(input())
an = list(map(int, input().split()))
an.sort()

M = int(input())
am = list(map(int, input().split()))

for i in am:
    start = 0
    end = len(an) - 1
    is_find_num = False
    while start <= end:
        mid = (start + end) // 2
        if i == an[mid]:
            print(1)
            is_find_num = True
            break
        elif i < an[mid]:
            end = mid - 1
        else:
            start = mid + 1
    if not is_find_num:
        print(0)