import sys
from collections import deque

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
C = list(map(int, sys.stdin.readline().split()))

D = deque()
for i in range(N):
    if (A[i] == 0):
        D.append(B[i])

for i in range(M):
    D.appendleft(C[i])
    print(D.pop(), end=' ')
