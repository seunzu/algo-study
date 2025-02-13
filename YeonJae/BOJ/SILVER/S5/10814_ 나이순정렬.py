n = int(input())  
age = []
name = []
for _ in range(n):
    a, b = input().split()  
    age.append(int(a))  # 나이는 정수로 변환하여 age 리스트에 추가
    name.append(b)      # 이름은 그대로 name 리스트에 추가

print(age)
print(name)




