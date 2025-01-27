# def solution(hp):
#     answer = 0
#     while hp > 0: 
#         if hp - 5 >= 0:  # 5를 뺄 수 있는 경우
#             hp -= 5
#             answer += 1
#         elif hp - 3 >= 0:  # 3을 뺄 수 있는 경우
#             hp -= 3
#             answer += 1
#         elif hp - 1 >= 0:  # 1을 뺄 수 있는 경우
#             hp -= 1
#             answer += 1
#     return answer

def solution(hp):
    answer = hp // 5  
    hp %= 5         
    answer += hp // 3 
    hp %= 3           
    answer += hp      
    return answer
