#겉넓이 구하기 
#n*m

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [[0 for _ in range(M + 2)]] \
      + [[0] + list(map(int, input().split())) + [0] for _ in range(N)] \
      + [[0 for _ in range(M + 2)]]
ans = 0
pos = [[1, 0], [-1, 0], [0, 1], [0, -1]] 
for i in range(1, N + 1):
    for j in range(1, M + 1):
        if arr[i][j] > 0: ans += 2
        for k in range(4): 
            compare = arr[i][j] - arr[i+pos[k][0]][j+pos[k][1]]
            if compare > 0: 
                ans += compare # 개수의 차를 더해줌
print(ans)