def solution(prices):
    answer = []
    #이중 포문
    for i in range(0,len(prices)):
        cnt=0
        for j in range(i+1,len(prices)):
            cnt+=1
            if prices[i]<=prices[j]:continue
            else:
                break
        answer.append(cnt)
    return answer