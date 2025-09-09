def solution(number, limit, power):
    num = []
     
    for i in range(1,number+1):
        count = 0
        # 약수 구하기 부분 수정 ver.
        for j in range(1,int(i**0.5)+1):
            if i % j == 0:
                count+=1
                if j < i//j:
                    count+=1
        num.append(count)
        
    for z in range(len(num)):
        if num[z] > limit:
            num[z] = power
    
    return sum(num)