def solution(num_list, n):
    answer = []
    for i in range(n,len(num_list)):
        answer.append(num_list[i])
    for i in range(0,n):
        answer.append(num_list[i])
    return answer


#다른 풀이 
def solution(num_list, n):
    answer = []
    f_ans=[]
    ans=[]
    for i in range(len(num_list)):
        if i<n:
            ans.append(num_list[i]);
        else: f_ans.append(num_list[i])
    return f_ans+ans