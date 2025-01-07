str_list = input().split(".")  # '.' 기준으로 나눔
answer = []

for s in str_list:
    if not s:  # 빈 문자열은 그대로 넘어감
        answer.append("")
        continue

    if len(s) % 2 != 0:  # 홀수 길이는 덮을 수 없음
        answer = -1
        break

    # 폴리오미노로 덮기
    a_count = len(s) // 4
    b_count = (len(s) % 4) // 2
    answer.append("AAAA" * a_count + "BB" * b_count)

if answer == -1:
    print(-1)
else:
    print(".".join(answer))
