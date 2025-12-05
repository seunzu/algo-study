def solution(n, words):
    checked=[words[0]]
    answer = [] #answer의 형태는 3번 3차례일때
    for i in range(1,len(words)):        
        if words[i][0]== words[i-1][-1] and words[i] not in checked:
            checked.append(words[i])
        else:
            return [(i%n)+1, (i//n)+1]

    return [0,0]