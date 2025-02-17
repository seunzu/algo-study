import math
def solution(n):
    #x가 소수인지 판별할때는 제곱근까지만 확인하면됨
    answer = 0
    for i in range(2,n+1):
        #소수:1과 자기 자신으로만 나누어지는 수 
        isprime=True
        for j in range(2,int(i**0.5)+1):
            if i%j==0: 
                isprime=False
                break
        if isprime:
            answer+=1
    return answer