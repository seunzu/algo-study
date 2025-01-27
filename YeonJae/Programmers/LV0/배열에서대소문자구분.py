def solution(strArr):
    answer = []
    #홀수번인덱스는 대문자,
    for i in range(len(strArr)):
        if i%2==0:
            answer.append(strArr[i].lower())
        else:
            answer.append(strArr[i].upper())
    return answer