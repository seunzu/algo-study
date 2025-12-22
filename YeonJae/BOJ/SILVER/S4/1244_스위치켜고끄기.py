n = int(input())
switches = [0] + list(map(int, input().split()))  # 1번 인덱스부터 사용
students = int(input())

for _ in range(students):
    gender, num = map(int, input().split())

    # 남
    if gender ==1:
        for i in range(num,n+1,num):
            switches[i]=1-switches[i]
    # 여
    else:
        left = right = num
        while left >= 1 and right <= n and switches[left] == switches[right]:
            switches[left] = 1 - switches[left]
            if left != right:
                switches[right] = 1 - switches[right]
            left -= 1
            right += 1

# 출력 형식: 20개씩 줄바꿈
for i in range(1, n + 1):
    print(switches[i], end=' ')
    if i % 20 == 0:
        print()
