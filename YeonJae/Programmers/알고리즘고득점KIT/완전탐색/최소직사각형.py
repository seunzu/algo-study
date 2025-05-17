def solution(sizes):
    answer = 0
    size1=[]
    size2=[]
    #요구사항: 모든 명함을 넣을 수 있는 최소 지갑 사이즈 
    for i in sizes:
        if i[0]>=i[1]:
            size1.append(i[0])
            size2.append(i[1])
        else:
            size1.append(i[1])
            size2.append(i[0])
            
    answer=max(size1)*max(size2)
    return answer