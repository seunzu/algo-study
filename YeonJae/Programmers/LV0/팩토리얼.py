def solution(n):
    fact = 1
    i = 1
    
    while fact * (i + 1) <= n:  
        i += 1
        fact *= i

    return i


