def solution(n):
    answer = []
    answer.append(n)
    while(n>1):
        if n%2==0:
            answer.append(n//2)
            n=n//2
        elif n%2!=0:
            answer.append(3*n+1)
            n=n*3+1
    return answer