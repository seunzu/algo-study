
H,W = map(int, input().split())
cloud=list(input()for _ in range(H))
next_cloud=[[-1]*W for _ in range(H)]
for i in range(H):
    for j in range(W):
        if cloud[i][j]=='c':
            next_cloud[i][j]=0
        elif 'c' in cloud[i][:j]:
            next_cloud[i][j]=j-cloud[i][:j].rindex('c')
for i in range(H):
    print(*next_cloud[i])
