# from itertools import permutations
# def solution(number, k):
#     perm=permutations(number,len(number)-k)
#     numbers = [int("".join(p)) for p in perm]
#     numbers.sort(reverse=True)
#     #위의 리스트 컴프리헨션이랑 같은거
#     #  numbers = []  
#     # for p in perm:
#     #     num = int("".join(p))  # 튜플을 문자열로 결합한 후 숫자로 변환
#     #     numbers.append(num)  # 리스트에 추가
#     return str(numbers[0])
# #     answer = ''
# #     return answer
def solution(number, k):
    stack = []
    for digit in number:
        # 스택에서 제거할 수 있고, 현재 숫자가 스택의 마지막 숫자보다 클 경우
        while k > 0 and stack and stack[-1] < digit:
            stack.pop()
            k -= 1
        stack.append(digit)
    
    # 스택에서 필요한 만큼만 가져오기
    return ''.join(stack[:len(number) - k])
