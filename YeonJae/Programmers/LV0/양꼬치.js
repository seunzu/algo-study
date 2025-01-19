function solution(n, k) {
    var answer = 0;
    if (n>=10){
        var service= Math.floor(n/10);
        answer=(n*12000)+(2000*(k-service))
    }
    else{
        answer=(n*12000)+(2000*k);
    }
    return answer;
}