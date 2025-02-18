N = int(input())
test_rooms = list(map(int, input().split()))
B, C = map(int, input().split())
answer = 0

for i in test_rooms:
    n = i
    n -= B
    answer += 1
    if n > 0:
        answer += n // C
        if n % C:
            answer += 1

print(answer)