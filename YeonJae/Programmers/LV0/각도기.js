function solution(angle) {
    if (angle < 90) return 1;
    if (angle === 90) return 2;
    if (angle < 180) return 3;
    return 4;
}


// function solution(angle) {
//     var answer = 0;
//     if(angle>0&& angle<90){
//         answer=1;
//     }
//     else if(angle===90){
//         answer=2;
//     }
//     else if (angle>90 && angle<180){
//         answer=3;
//     }
//     else if (angle===180){
//         answer=4;
//     }
//     return answer;
// }