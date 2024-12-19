expression = input().strip()

# 뺄셈 기호를 기준으로 나누기
parts = expression.split('-')

# 첫 번째 부분의 합 계산
initial_sum = 0
for num in parts[0].split('+'):
    initial_sum += int(num)

# 나머지 부분의 합 계산 (모두 뺄셈 처리)
rest_sum = 0
for part in parts[1:]:
    for num in part.split('+'):
        rest_sum += int(num)

# 결과 계산
result = initial_sum - rest_sum
print(result)
