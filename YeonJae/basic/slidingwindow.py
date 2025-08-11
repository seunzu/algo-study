## 연속 구간 합. 최대 , 최소를 o(n)으로 계산 
def sliding_window(arr,k):
    n=len(arr)
    window_sum=sum(arr[:k])