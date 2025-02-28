import sys

def calculate_team_score(team):
    """ 주어진 팀의 능력치 합을 계산하는 함수 """
    score = 0
    for i in range(len(team)):
        for j in range(i+1, len(team)):
            score += s[team[i]][team[j]] + s[team[j]][team[i]]
    return score

def backtrack(start, count):
    global min_diff

    # 팀이 절반이 되면 나머지는 자동으로 다른 팀이 됨
    if count == n // 2:
        start_team = [i for i in range(n) if visited[i]]
        link_team = [i for i in range(n) if not visited[i]]

        start_score = calculate_team_score(start_team)
        link_score = calculate_team_score(link_team)

        min_diff = min(min_diff, abs(start_score - link_score))
        return
    
    # 조합 생성 (N과 M 방식)
    for i in range(start, n):
        if not visited[i]:
            visited[i] = True
            backtrack(i + 1, count + 1)
            visited[i] = False

# 입력 처리
n = int(sys.stdin.readline().strip())
s = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

visited = [False] * n
min_diff = float('inf')

# 백트래킹 시작
backtrack(0, 0)

print(min_diff)
