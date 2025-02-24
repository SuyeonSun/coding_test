import sys

def solve():
    input = sys.stdin.read
    data = input().split("\n")

    N = int(data[0])  # 총 날짜 수
    T = [0] * (N + 1)  # 상담 기간
    P = [0] * (N + 1)  # 상담 수익
    dp = [0] * (N + 2)  # DP 배열 (N+1일 이후의 상태까지 고려)

    # 입력 데이터 저장
    for i in range(1, N + 1):
        if data[i].strip():
            t, p = map(int, data[i].split())
            T[i] = t
            P[i] = p

    # DP 테이블 채우기 (Bottom-Up)
    for i in range(1, N + 1):
        # **현재까지의 최대 수익 유지**
        dp[i] = max(dp[i], dp[i - 1])

        # **현재 상담을 수행할 수 있다면 갱신**
        if i + T[i] <= N + 1:
            dp[i + T[i]] = max(dp[i + T[i]], dp[i] + P[i])

    # 마지막 날까지 최대 수익 출력
    print(max(dp))

if __name__ == "__main__":
    solve()
