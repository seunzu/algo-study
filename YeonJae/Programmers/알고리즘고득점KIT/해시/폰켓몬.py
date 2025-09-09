def solution(nums):
    answer = list(dict.fromkeys(nums)) 
    
    if (len(nums) // 2) <= len(answer):
        return (len(nums) // 2)
    
    return len(answer)