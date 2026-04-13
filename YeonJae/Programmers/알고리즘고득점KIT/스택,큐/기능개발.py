import math
def solution(progresses, speeds):
    left_time=list()
    n = len(progresses)
    for i in range(n):
        left_time.append(math.ceil((100 - progresses[i]) / speeds[i]))

    front = left_time[0]
    answer = []
    count = 1

    for i in range(1,len(progresses)) :
        if front >= left_time[i] :
            count += 1

        else :
            front = left_time[i]
            answer.append(count)
            count = 1

    answer.append(count)


    return answer