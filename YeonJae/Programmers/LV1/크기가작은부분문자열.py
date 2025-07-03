def solution(t, p):
  answer = 0
  p_len = len(p)
  t_len = len(t)
  p = int(p)
  for i in range(0,t_len+1-p_len):
      if int(t[i:i+p_len]) <= p:
          answer+=1
  return answer

# def solution(t, p):
#     answer = 0
#     idx=len(p)
#     arr=[]
#     cnt=0
#     for i in range(len(t)-idx+1):
#         arr.append(t[i:i+idx])
#     for i in range(len(arr)):
#         if int(arr[i])<=int(p):
#             cnt+=1
#     return cnt



#가능한 부분 문자열의 개수
# t의 길이가 n, p의 길이가 m일 때, 가능한 부분 문자열의 개수는
# 𝑛−𝑚+1