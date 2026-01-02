import heapq
import sys

input = sys.stdin.readline

heap = []
n = int(input())
for _ in range(n):
    x = int(input())
    if x == 0:
        if not heap:
            print(0)
        else:
            print(-heapq.heappop(heap)) 
    else:
        heapq.heappush(heap, -x)
