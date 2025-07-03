#걷는 거리가 같을때는 아래층 방 선호 
# 102호보다는 301호 선호 
t=int(input())
#h,w,n입력받기 (h: 호텔 층수, w: 호수 n몇번째 )

for _ in range(t):
    h, w, n = map(int, input().split())
    floor = n % h if n % h != 0 else h
    room_number = (n - 1) // h + 1  # 혹은 n // h + 1 if n % h != 0 else n // h
    
    print(f"{floor}{room_number:02d}")