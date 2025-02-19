import sys
input = sys.stdin.readline

def evaluate_postfix(expression):
    stack = []

    for char in expression.strip():
        if char.isdigit():  
            stack.append(int(char))
        else:  
            b = stack.pop()  
            a = stack.pop() 
            
            if char == '+':
                stack.append(a + b)
            elif char == '-':
                stack.append(a - b)
            elif char == '*':
                stack.append(a * b)
            elif char == '/':
                stack.append(a // b) 

    return stack[0]  


expression = input().strip()
print(evaluate_postfix(expression))
