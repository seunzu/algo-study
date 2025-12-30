import sys
S=sys.stdin.readline().rstrip()
cnt=set()

for i in range(0, len(S)):
    for j in range(i, len(S)):
        cnt.add(S[i:j+1])

print(len(cnt))
