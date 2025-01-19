function solution(sides) {
    var side= sides.sort((a,b)=>a - b); //오름차순 정렬
    if(side[2]<side[0]+side[1]){
        return 1;
    }
    return 2;
    
}

