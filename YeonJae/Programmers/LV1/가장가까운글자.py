def solution(s):
    answer=[]
    sentence={}
    for i in range(len(s)):
        if s[i] not in sentence:
            answer.append(-1)
        else:
            answer.append(i-sentence[s[i]])
        sentence[s[i]]=i

    return answer