dp=[0]*100
def fibo(x):
    if x==1 or x==2:
        return 1
    if dp[x]!=0:
        return dp[x]
    dp[x]=fibo(x-1)+fibo(x-2)
    return dp[x]
n=int(input())
print(fibo(n))
# print(f"피보나치수({n}) : {fibo(n)}")