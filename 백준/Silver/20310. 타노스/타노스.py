str = input()

zero_cnt = 0
one_cnt = 0

for s in str:
    if s == "0":
        zero_cnt += 1
    else:
        one_cnt += 1

answer = ""
for i in range(zero_cnt // 2):
    answer += "0"
for i in range(one_cnt // 2):
    answer += "1"

list(answer).sort()
print("".join(answer))