n = int(input())
for _ in range(n):
    stack=[]
    vps = input().strip() #공백제거
    is_valid=True #유효성 검증
    for i in vps:
        if i=='(':
            stack.append(i)
        elif i==')':
            if stack: 
                stack.pop()
            else:
                is_valid=False
                break


    if stack:
        is_valid=False
        
    if is_valid: print('YES')
    else: print("NO")