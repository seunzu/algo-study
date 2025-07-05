def solution(s):
    aswer=''
    answer=s.lower()
    a=answer.count('p')
    b=answer.count('y')
    if a>b or a<b :
        return False
    elif a==b:
        return True
  