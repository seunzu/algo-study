def solution(food):
    answer = ''
    reverse_answer=''
    for i in range(len(food)):
        answer+=str(i)*(food[i]//2)
    reverse_answer=answer[::-1]
    answer+='0'
    answer+=reverse_answer
    return answer
