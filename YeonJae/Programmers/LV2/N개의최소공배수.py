import math

def solution(arr):
    result = arr[0]
    for i in range(1, len(arr)):
        result = result * arr[i] // math.gcd(result, arr[i])
    return result


# import math
# from functools import reduce

# def solution(arr):
#     return reduce(lambda a, b: a * b // math.gcd(a, b), arr)
