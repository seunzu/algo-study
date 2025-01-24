def solution(i, j, k):
    cnt = 0
    k = str(k)  # k를 문자열로 변환
    for num in range(i, j+1):  # 숫자를 하나씩 순회
        for digit in str(num):  # 각 숫자를 문자열로 변환하여 자릿수 순회
            if digit == k:  # k와 자릿수를 비교
                cnt += 1
    return cnt
