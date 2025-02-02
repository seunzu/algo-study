def solution(a, b):
    if a%2!=0 and b%2!=0: return a*a+b*b
    elif a%2!=0 and b%2==0 or a%2==0 and b%2!=0 : return 2*(a+b)
    else: return abs(a-b)