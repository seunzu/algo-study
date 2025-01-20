function solution(num_list) {
    var odd=0; //홀수번째 원소들 합
    var even=0; //짝수번째 
    for(let i=0; i<num_list.length; i++){
        if(i===0||i%2===0){
            odd+=num_list[i];
        }else{ even+=num_list[i]};
    }
    if(odd>even) return odd;
    else if(odd<=even) return even;
    
}