def solution(my_string):
    return ''.join(dict.fromkeys(my_string))


#중복문자 제거 
def solution(my_string):
    answer = ''
    for i in my_string:
        if i in answer:
            continue
        else:
            answer+=i
    return answer