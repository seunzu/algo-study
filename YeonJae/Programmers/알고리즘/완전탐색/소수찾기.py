from itertools import permutations
import math
def solution(numbers):
    answer = 0
    num=[i for i in numbers]
    
    #소수 찾기 
    def isPrime(n):
        if n<=1:
            return False
        else:
            for i in range(2,int(math.sqrt(n)+1)):
                if n % i==0:
                    return False
        return True
    count=[]
    for i in range(1,len(num)+1):
        ans=set(list(permutations(num,i)))
        for j in ans:
            if isPrime(int(''.join(j))):
                count.append(int(''.join(j)))
    
    return len(set(count))
    
    