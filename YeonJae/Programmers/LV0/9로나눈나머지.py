def solution(number):
    answer = 0
    s=0
    for i in range(len(number)):
        s+=int(number[i])
    answer=s%9
    return answer