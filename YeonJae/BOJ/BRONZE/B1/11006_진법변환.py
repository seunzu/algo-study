def convert_base(n, b):
    digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    result = ""
    if n == 0:
        return "0"
    while n > 0:
        result = digits[n % b] + result
        n //= b
    return result

n, b = map(int, input().split())
print(convert_base(n, b))