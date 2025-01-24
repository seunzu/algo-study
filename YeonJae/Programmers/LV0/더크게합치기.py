def solution(a, b):
    answer = 0
    a=str(a)
    b=str(b)
    num1=''
    num2=''
    num1=a+b
    num2=b+a   
    if int(num1)>int(num2):return int(num1)
    else : return int(num2)

# def solution(a, b):
#     return max(int(str(a) + str(b)), int(str(b) + str(a)))
