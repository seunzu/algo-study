def solution(s):
    result = ''
    idx = 0  # 단어 내 인덱스
    for ch in s:
        if ch == ' ':  # 공백이면
            result += ' '
            idx = 0  # 단어 인덱스 리셋
        else:
            if idx % 2 == 0:
                result += ch.upper()
            else:
                result += ch.lower()
            idx += 1
    return result
