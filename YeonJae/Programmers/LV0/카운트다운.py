# def solution(start_num, end_num):
#     answer = []
#     for i in range(end_num,start_num+1,1):
#         answer.append(i)
        
#     answer.reverse()
#     return answer

def solution(start_num, end_num):
    answer = []
    for i in range(start_num,end_num-1,-1):
        answer.append(i)
    return answer