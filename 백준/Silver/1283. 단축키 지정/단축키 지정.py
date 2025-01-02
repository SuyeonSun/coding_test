def assign_shortcuts(sentences):
    used_shortcuts = set()  # 이미 사용된 단축키 저장
    result = []

    for sentence in sentences:
        words = sentence.split()  # 문장을 단어 단위로 분리
        shortcut_assigned = False

        # 단축키 지정: 각 단어의 첫 글자를 먼저 시도
        for word_index in range(len(words)):
            word = words[word_index]
            first_char = word[0].upper()
            if first_char not in used_shortcuts:
                used_shortcuts.add(first_char)
                words[word_index] = "[" + word[0] + "]" + word[1:]
                shortcut_assigned = True
                break

        # 첫 글자로 단축키를 지정하지 못한 경우, 전체 문자열에서 단축키 지정
        if not shortcut_assigned:
            for word_index in range(len(words)):
                word = words[word_index]
                for char_index in range(len(word)):
                    char = word[char_index].upper()
                    if char not in used_shortcuts:
                        used_shortcuts.add(char)
                        words[word_index] = word[:char_index] + "[" + word[char_index] + "]" + word[char_index + 1:]
                        shortcut_assigned = True
                        break
                if shortcut_assigned:
                    break

        # 결과에 변환된 문장 추가
        result.append(" ".join(words))

    return result

# 입력 처리
n = int(input())  # 문장의 개수
sentences = [input() for _ in range(n)]

# 결과 출력
for res in assign_shortcuts(sentences):
    print(res)
