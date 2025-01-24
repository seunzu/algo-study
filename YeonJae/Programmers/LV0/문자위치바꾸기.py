def solution(my_string, num1, num2):
    m=list(my_string) 
    m[num1],m[num2]= m[num2],m[num1]
    return ''.join(m)