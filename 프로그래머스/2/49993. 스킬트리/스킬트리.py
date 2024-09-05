def solution(skill, skill_trees):
    answer = 0
    
    for skill_tree in skill_trees:
        skill_index = 0
        for char in skill_tree:
            if char in skill:
                if char != skill[skill_index]:
                    break                    
                skill_index += 1
        else:
            answer += 1

    return answer