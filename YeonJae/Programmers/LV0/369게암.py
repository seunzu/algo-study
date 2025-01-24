def solution(order):
    answer = 0
    order=str(order)
    for i in range (len(order)):
        if '3' ==order[i] or '6'==order[i] or '9'==order[i]:
            answer+=1
    return answer