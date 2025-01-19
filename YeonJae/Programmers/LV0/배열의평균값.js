function solution(numbers) {
    var sum = 0;
    for (let i = 0; i < numbers.length; i++) {
        sum += numbers[i];
    }
    var answer = sum / numbers.length; // 평균을 실수로 계산
    return answer;
}
