def solution(date1, date2):
    # 연도 비교
    if date1[0] < date2[0]:
        return 1
    # 연도가 같으면 월 비교
    elif date1[0] == date2[0]:
        if date1[1] < date2[1]:
            return 1
        # 월이 같으면 일 비교
        elif date1[1] == date2[1]:
            if date1[2] < date2[2]:
                return 1
    # date1이 더 크거나 같은 경우
    return 0

