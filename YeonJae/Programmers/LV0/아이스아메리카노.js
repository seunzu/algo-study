function solution(money) {
    var answer = [];
    var cnt=0;
    while(true){
        if(money-5500<0){
            break;
        }
        money=money-5500;
        cnt++;
    }
    answer.push(cnt);
    answer.push(money);
    return answer;
}