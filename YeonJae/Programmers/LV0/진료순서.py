def solution(emergency):
    answer = []
    emer=sorted(emergency, reverse=True)
    answer=[emer.index(i)+1 for i in emergency]
    return answer



