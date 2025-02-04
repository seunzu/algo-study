from collections import Counter
def solution(participant, completion):
    participant_cnt=Counter(participant)
    completion_cnt=Counter(completion)
    #완주자 명단에서 참가자 명단을 빼면, 남은 사람이 완주하지 못한 선수
    answer=(participant_cnt-completion_cnt).keys()
    return list(answer)[0] # 딕셔너리에서 key 값만 가져오기
