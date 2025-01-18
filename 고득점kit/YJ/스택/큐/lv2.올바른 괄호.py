def solution(s):
    answer = True
    stack=[]
    for i in s:
       # ( 이면, 넣기 
        if i=='(':
            stack.append(i)
        elif i==')':
            if stack:
                stack.pop()
            else: return False
    if len(stack)==0:
        return True
    else: return False
