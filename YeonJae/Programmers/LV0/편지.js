function solution(message) {
    var answer = 0;
    var count=0;
    // 공백포함
    for(let i=0; i<message.length; i++){
        count+=1
    }
    return count*2;
}

// function solution(message) {
//     return message.length * 2;
// }
