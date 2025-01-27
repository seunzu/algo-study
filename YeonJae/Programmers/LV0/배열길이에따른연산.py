def solution(arr, n):
    answer = []
    if len(arr)%2==0:#arr길이가 짝수 일때 
        for i in range(len(arr)):
            if i%2==0 or i==0:
                answer.append(arr[i])
            else: answer.append(arr[i]+n)
    else:
        for i in range(len(arr)):
            if i%2==0 or i==0:
                answer.append(arr[i]+n)
            else: answer.append(arr[i])       
            
    return answer