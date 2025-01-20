function solution(my_string, n) {
    var answer = '';
    for(let i=0; i<my_string.length; i++){
        for(let j=0; j<n;j++){
            answer+=my_string[i];
        }
    }
    return answer;
}


//간단하게 풀기 #2
function solution(my_string, n) {
    return my_string.split('').map(char => char.repeat(n)).join('');
}
