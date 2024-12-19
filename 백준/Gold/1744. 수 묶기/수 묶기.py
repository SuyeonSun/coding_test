# 입력 받기
n = int(input())
numbers = []
for _ in range(n):
    numbers.append(int(input()))

# 양수, 음수, 0 분리
positives = []
negatives = []
result = 0

for num in numbers:
    if num > 1:
        positives.append(num)
    elif num <= 0:
        negatives.append(num)
    else:  # num == 1
        result += 1  # 1은 곱하지 않고 더하는 것이 유리

# 양수는 내림차순, 음수는 오름차순으로 정렬
positives.sort(reverse=True)
negatives.sort()

# 양수 처리
i = 0
while i < len(positives) - 1:
    result += positives[i] * positives[i + 1]
    i += 2
if i < len(positives):  # 남은 숫자가 있다면 더하기
    result += positives[i]

# 음수 처리
i = 0
while i < len(negatives) - 1:
    result += negatives[i] * negatives[i + 1]
    i += 2
if i < len(negatives):  # 남은 숫자가 있다면 더하기
    result += negatives[i]

# 결과 출력
print(result)