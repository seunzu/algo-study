def solution(spell, dic):
    answer = 0
    for i in dic:
        if not set(spell)-set(i):
            return 1
    return 2
