function solution(numbers) {
    var number=numbers.sort((a,b)=>a-b);
    return number[number.length-1]*number[number.length-2];
}