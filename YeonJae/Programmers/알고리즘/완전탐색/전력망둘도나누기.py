from collections import deque

# 한 쪽 전력망의 송전탑 개수를 BFS로 구하는 함수
def bfs(start, graph, visited):
    count = 1
    queue = deque([start])
    visited[start] = True

    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
                count += 1
    return count

# 메인 함수
def solution(n, wires):
    min_gap = n  # 최대 차이는 n이니까 

    for i in range(len(wires)):
        temp = wires[:i] + wires[i+1:]
        graph = [[] for _ in range(n + 1)]
        for a, b in temp:
            graph[a].append(b)
            graph[b].append(a)

        # BFS
        visited = [False] * (n + 1)
        count = bfs(1, graph, visited)  

        diff = abs(count - (n - count))
        min_gap = min(min_gap, diff)

    return min_gap
