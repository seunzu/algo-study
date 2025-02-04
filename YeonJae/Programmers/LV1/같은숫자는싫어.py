def solution(arr):
    answer = [arr[0]]
    for i in range(1,len(arr)):
        if arr[i]!=arr[i-1]:
            answer.append(arr[i])
    return answer


#다른 풀이 
def solution(arr):
    return [arr[i] for i in range(len(arr)) if i == 0 or arr[i] != arr[i - 1]]
