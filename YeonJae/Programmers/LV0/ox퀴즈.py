def solution(quiz):
    answer = []
    for q in quiz:
        cells = q.split()
        if cells[1]=="+":
            real = int(cells[0])+int(cells[2])
        elif cells[1]=="-":
            real =  int(cells[0])-int(cells[2])
        if real==int(cells[4]):
            answer.append("O")
        else:
            answer.append("X")
    return answer