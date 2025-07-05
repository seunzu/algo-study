def solution(babbling):
    count = 0
    words = ["aya", "ye", "woo", "ma"]

    for b in babbling:
        idx = 0
        prev = ''
        is_valid = True

        while idx < len(b):
            matched = False
            for w in words:
                if b.startswith(w, idx):
                    if w == prev:  # 같은 단어 연속 사용 시 탈락
                        is_valid = False
                        break
                    prev = w
                    idx += len(w)
                    matched = True
                    break
            if not matched:
                is_valid = False
                break

        if is_valid:
            count += 1

    return count
