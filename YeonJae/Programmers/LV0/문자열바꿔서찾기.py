def solution(myString, pat):
    myStr=''
    answer = 0
    for i in myString:
        if i =='A':  myStr+=i.replace('A','B')
        elif i=='B': myStr+=i.replace('B','A')
    if pat in myStr:
        return 1
    else: return 0
