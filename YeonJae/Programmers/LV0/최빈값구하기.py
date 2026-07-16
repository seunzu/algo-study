from collections import Counter

def solution(array):
    counter = Counter(array)

    max_count = max(counter.values())

    # 최빈값이 여러 개인지 확인
    if list(counter.values()).count(max_count) > 1:
        return -1

    # 최빈값 반환
    for num, cnt in counter.items():
        if cnt == max_count:
            return num