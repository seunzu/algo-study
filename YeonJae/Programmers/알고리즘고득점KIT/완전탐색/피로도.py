from itertools import permutations
def solution(k, dungeons):
    max_count=0
    answer = -1
    for perm in permutations(dungeons):
        fatigue=k
        count=0
        for dungeon in perm:
            if fatigue>=dungeon[0]:
                fatigue-=dungeon[1]
                count+=1
            else:
                break
        max_count=max(max_count,count)
    return max_count