from collections import Counter

N = int(input())
for i in range(N):
    arr = list(map(int, input().split()))
    n = arr[0] // 2
    arr = arr[1:]
    counter = Counter(arr)
    flag = False
    for i in counter:
        if counter[i] > n:
            print(i)
            flag = True
            break
    if not flag:
        print("SYJKGW")