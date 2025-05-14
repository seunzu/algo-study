while True:
    S = input()
    if S == ".":
        break 
    stack = []
    is_balanced = True  
    for ch in S:
        if ch == '(' or ch == '[':
            stack.append(ch)
        elif ch == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                is_balanced = False
                break
        elif ch == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                is_balanced = False
                break

    if is_balanced and not stack:
        print("yes")
    else:
        print("no")