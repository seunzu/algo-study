def solution(answers):
    answer = [0 for i in range(3)]

    ans1 = [1,2,3,4,5]
    ans2 = [2,1,2,3,2,4,2,5]
    ans3 = [3,3,1,1,2,2,4,4,5,5]
    
    for i in range(len(answers)):
        ans = answers[i]
        if(ans1[i%len(ans1)] == ans):
            answer[0] += 1
        if(ans2[i%len(ans2)] == ans):
            answer[1] += 1
        if(ans3[i%len(ans3)] == ans):
            answer[2] += 1     
    
    result = []
    for i in range(len(answer)):
        if(answer[i] == max(answer)):
            result.append(i+1)
    
    return sorted(result)
