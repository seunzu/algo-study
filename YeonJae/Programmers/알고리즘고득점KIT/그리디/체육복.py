def solution(n, lost, reserve):
    # 여벌 체육복을 가진 학생이 도난당한 경우
    lost_set = set(lost) - set(reserve)
    reserve_set = set(reserve) - set(lost)
    
    answer = n - len(lost_set)
    
    for i in sorted(lost_set):  # 정렬
        if i - 1 in reserve_set:
            reserve_set.remove(i - 1)
            answer += 1
        elif i + 1 in reserve_set:
            reserve_set.remove(i + 1)
            answer += 1

    return answer