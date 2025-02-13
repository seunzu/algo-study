n = int(input())
ans = [input() for _ in range(n)]

ans = list(set(ans))

ans.sort(key=lambda x: (len(x), x))

for word in ans:
    print(word)
