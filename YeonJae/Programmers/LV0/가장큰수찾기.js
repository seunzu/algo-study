function solution(array) {
    var answer = [];
    answer.push(Math.max(...array));
    answer.push(array.indexOf(Math.max(...array)));
    return answer;
}
//한줄 코드
//  return [Math.max(...array),array.indexOf(Math.max(...array))]