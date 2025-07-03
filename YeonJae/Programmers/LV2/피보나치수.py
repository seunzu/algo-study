def solution(n):
    mod = 1234567
    a, b = 0, 1  
    for _ in range(2, n + 1):
        a, b = b, (a + b) % mod  # F(n) = F(n-1) + F(n-2) (모듈러 연산 적용)
    return b

