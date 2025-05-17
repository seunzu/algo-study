def solution(s):
    stack = []
    for i in s:
        if i == '(':
            stack.append(i)
        else:
            if stack:
                stack.pop()  # 짝이 맞으면 pop
            else:
                return False  # 닫는 괄호가 더 많으면 False
    
    return not stack  
