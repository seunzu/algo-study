###10-> n 진수 
def solution(n):
    answer = 0
    rev_base=''
    while n>0:
        n,mod=divmod(n,3)
        rev_base+=str(mod)
        #원래는 역순인 진수를 뒤집어줘야 원래 변환하고자 하는 값이 나옴,
        # 근데 이 문제는reverse한 값을 구하라고 하니까 그과정이 없어도됨 
        #  return rev_base[::-1] 
    answer=int(rev_base,3)


    return answer

# ==================================
# n진수->10진수
# print(int('404',5))
# 10진수 ->2,8,16진수
# print(bin(11))
# print(oct(11))
# print(hex(11))
# 진법 표시 지우기 
# print(bin(11)[2:])
# print(oct(11)[2:])
# print(hex(11)[2:])
# ==============================

# print(solution(int('c',16),4)) # 16진수인 C를 4진수로 바꾸는것
# print(solution(int('4',6),3))  # 6진수인 4를 3진수로 바꾸는것
# 출처: https://eesko.tistory.com/150 [미정:티스토리]
