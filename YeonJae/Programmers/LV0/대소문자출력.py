

string = input()
answer = []

for i in string:
    if i.isupper():  # 대문자인 경우
        answer.append(i.lower())  # 소문자로 변환하여 추가
    elif i.islower():  # 소문자인 경우
        answer.append(i.upper())  # 대문자로 변환하여 추가
    else:  # 알파벳이 아닌 경우
        answer.append(i)  # 그대로 추가

# 리스트를 문자열로 변환하여 출력
print(''.join(answer))
