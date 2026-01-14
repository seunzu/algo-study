n,m=list(map(int,input().split()))
card=list(map(int,input().split()))
anw=0 

total_sum=0
length=len(card)

# 3중 반복문 i, j ,k 사용
count = 0
for i in range(0, length):
    for j in range(i + 1, length):
        for k in range(j + 1, length):
            sum_card = card_list[i] + card_list[j] + card_list[k]
            if sum_card <= M:
                result = max(anw, sum_card)

print(anw)