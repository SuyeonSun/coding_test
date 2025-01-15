import sys
input = sys.stdin.readline

M = int(input())
S = set()
for _ in range(M):
    inputs = input().strip().split()
    command = inputs[0]

    if command == "add":
        S.add(int(inputs[1]))
    elif command == "remove":
        S.discard(int(inputs[1]))  # 안전하게 삭제
    elif command == "check":
        print(1 if int(inputs[1]) in S else 0)
    elif command == "toggle":
        value = int(inputs[1])
        if value in S:
            S.remove(value)
        else:
            S.add(value)
    elif command == "all":
        S = set(range(1, 21))  # 1부터 20까지의 숫자를 추가
    elif command == "empty":
        S.clear()  # 집합을 비움
