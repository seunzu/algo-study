def solution(n):
    answer = 0
    nums=[i for i in range(1,n+1)]
    start,end=0,0
    current_sum=0
    
    while start<n:
        if current_sum==n:
            answer+=1
            current_sum-=nums[start]
            start+=1
        elif current_sum <n:
            if end==n:
                break
            current_sum+=nums[end]
            end+=1
        else:
            current_sum-=nums[start]
            start+=1
    return answer