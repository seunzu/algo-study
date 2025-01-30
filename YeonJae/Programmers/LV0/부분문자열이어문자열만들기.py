def solution(my_strings, parts):
    result = ""
    for i in range(len(my_strings)):
        s, e = parts[i]  # 시작 인덱스 s, 끝 인덱스 e 가져오기
        result += my_strings[i][s:e+1]  # 부분 문자열을 추출하고 result에 추가
    return result


# def solution(my_strings, parts):
#     return ''.join(my_strings[i][s:e+1] for i, (s, e) in enumerate(parts))
