def solution(num_list):
    answer = 0
    mul=1
    s=0
    for i in num_list:
        s+=i
        mul*=i
    return 1 if mul <s * s else 0
