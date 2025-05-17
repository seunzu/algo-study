def solution(citations):
    cnt=0
    citation=sorted(citations,reverse=True)
    for i,c in enumerate(citation):
        if c>=i+1: #인용횟수가 논문개수 이상일때
            cnt=i+1
        else: break
    return cnt
