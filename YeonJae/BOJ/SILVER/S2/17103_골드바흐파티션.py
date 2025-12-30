import sys
input = sys.stdin.readline

T = int(input())
nums = [int(input()) for _ in range(T)]

MAX_N = max(nums)
is_prime = [True] * (MAX_N + 1)
is_prime[0] = is_prime[1] = False

for i in range(2, int(MAX_N ** 0.5) + 1):
    if is_prime[i]:
        for j in range(i * i, MAX_N + 1, i):
            is_prime[j] = False

for N in nums:
    count = 0
    for p in range(2, N // 2 + 1):
        if is_prime[p] and is_prime[N - p]:
            count += 1
    print(count)
