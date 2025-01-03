N = int(input())
arr = []
for i in range(N):
    word = input()
    if word not in arr:
        arr.append(word)
arr = sorted(arr, key = lambda x: (len(x), x))
for i in arr:
    print(i)