import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
num = list(map(int, input().split()))
q = deque(_ for _ in range(1, N + 1))

count = 0
for i in num:
    while True:
        if q[0] == i:
            q.popleft()
            break
        else:
            if q.index(i) < len(q) / 2:
                while q[0] != i:
                    q.append(q.popleft())
                    count += 1
            else:
                while q[0] != i:
                    q.appendleft(q.pop())
                    count += 1
print(count)