def is_valid(s):
    stack = []
    pair = {')': '(', ']': '[', '}': '{'}
    
    for char in s:
        if char in '([{':
            stack.append(char)
        elif char in ')]}':
            if not stack or stack[-1] != pair[char]:
                return False
            stack.pop()
    return len(stack) == 0

def solution(s):
    answer = 0
    n = len(s)
    
    for i in range(n):
        rotated = s[i:] + s[:i]
        if is_valid(rotated):
            answer += 1
            
    return answer
