# def solution(age):
#     # 숫자를 문자열로 변환 후 각 숫자를 알파벳으로 매핑
#     return ''.join(chr(ord('a') + int(digit)) for digit in str(age))
def solution(age):
    result = ""
    for digit in str(age):
        converted_char = chr(ord('a') + int(digit))
        result += converted_char
    return result
