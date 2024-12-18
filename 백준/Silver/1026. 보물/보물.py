N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

# [[2, 0], [7, 1], [8, 2], [3, 3], [1, 4]]
# [[8, 2], [7, 1], [3, 3], [2, 0], [1, 4]] 

B_seq = []
for i in range(len(B)):
    B_seq.append([B[i], i])
B_seq.sort(reverse = True)

A.sort()

A_seq = [0] * len(A)
for i in range(len(A)):
    A_seq[B_seq[i][1]] = A[i]

sum = 0
for i in range(len(A_seq)):
    sum += (A_seq[i] * B[i])

print(sum)