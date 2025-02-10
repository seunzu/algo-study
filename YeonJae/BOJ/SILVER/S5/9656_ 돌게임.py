n = int(input())

# dp[i]는 i개의 돌이 남았을 때 현재 차례인 사람이 이길 수 있는지 여부
dp = [0] * 1001

# 기본 케이스 설정
dp[1] = 0  # 1개 남으면 현재 차례 사람이 짐
dp[2] = 1  # 2개 남으면 현재 차례 사람이 이김
dp[3] = 0  # 3개 남으면 현재 차례 사람이 짐

# 동적 프로그래밍으로 나머지 경우 계산
for i in range(4, n+1):
    if dp[i-1] == 0 or dp[i-3] == 0:
        dp[i] = 1
    else:
        dp[i] = 0

# 결과 출력
if dp[n] == 1:
    print("SK")
else:
    print("CY")
