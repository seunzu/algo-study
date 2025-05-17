# def solution(prices):
#     answer = []
#     for i in range(len(prices)):
#         cnt = 0
#         for j in range(i + 1, len(prices)):
#             cnt += 1
#             if prices[j] < prices[i]:
#                 break
#         answer.append(cnt)
#     return answer
def solution(prices):
    answer = [0] * len(prices)
    stack = []

    for i, price in enumerate(prices):
        # 스택에 있는 가격보다 현재 가격이 떨어졌다면
        while stack and prices[i] < prices[stack[-1]]:
            top = stack.pop()
            answer[top] = i - top  # 가격이 떨어진 시점 - 시작 시점
        stack.append(i)

    # 끝까지 가격이 안 떨어진 애들 처리
    while stack:
        top = stack.pop()
        answer[top] = len(prices) - 1 - top

    return answer