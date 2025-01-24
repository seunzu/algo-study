def solution(myString, pat):
    answer = 0
    if pat.upper() in myString.upper(): return 1
    return 0