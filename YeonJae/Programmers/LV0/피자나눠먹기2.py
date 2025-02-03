def solution(n):
    answer = 1
    #피자는 항상 6조각 
    while(True):
        if (6*answer)%n==0: break
        else: answer+=1
    return answer
# import math

# def solution(n):
#     return (n * 6) // math.gcd(n, 6) // 6
