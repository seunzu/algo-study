def solution(arr, flag):
    answer = []
    for i in range(0,len(flag)):
        if flag[i]==True:
            for j in range(0, arr[i]*2):
                answer.append(arr[i])
        else:
            for k in range(0,arr[i]):
                answer.pop()
    return answer