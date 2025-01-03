n = int(input())
answer = 0
for i in range(n):
    s = set()
    arr = list(input())
    last_word = ""
    for j in arr:
        if last_word == j:
            continue
        elif j in s:
            break
        else:
            s.add(j)
            last_word = j
    else:
        answer += 1
print(answer)