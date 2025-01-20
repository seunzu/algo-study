function solution(numbers) {
    var answer = [];
    numbers.sort((a,b)=>b-a);
    for (let i=0; i<numbers.length-1; i++){
        for(let j=i+1; j<numbers.length; j++){
            answer.push(numbers[i] * numbers[j]);
        }
    }
    return Math.max(...answer);
}