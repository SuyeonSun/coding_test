A, B = map(int, input().split())
A_set = set(map(int, input().split()))
B_set = set(map(int, input().split()))
answer = []
for i in A_set:
    if i not in B_set:
        answer.append(i)
answer.sort()
print(len(answer))
print(" ".join(map(str, answer)))
