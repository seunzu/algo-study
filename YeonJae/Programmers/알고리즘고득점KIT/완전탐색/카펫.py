def solution(brown, yellow):
    #전체 카펫 크기 구하기 
    total=brown+yellow
    
    for height in range(3, total):
        if total%height==0:
            width=total//height
            if width>=height:
                if(width-2)*(height-2)==yellow:
                    return [width, height]
        
