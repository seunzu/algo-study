# def solution(my_string, s, e):
#     answer = ''
#     for i in range(0, s):
#         answer += my_string[i]
#     for i in range(e, s-1, -1):
#         answer += my_string[i]
#     for i in range(e+1,len(my_string)):
#         answer += my_string[i]

#     return answer
def solution(my_string, s, e):
    return my_string[:s] + my_string[s:e+1][::-1] + my_string[e+1:]

