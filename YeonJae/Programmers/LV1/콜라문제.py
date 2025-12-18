def solution(a, b, n):
    answer = 0 # 받은 병의 개수
    while n >= a:
        answer += (n // a) * b
        n = (n // a) * b + (n % a)
    return answer