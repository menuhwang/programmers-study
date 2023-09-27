def solution(s1, s2):
    answer = 0
    for n in s1:
        for m in s2:
            if n == m:
                answer += 1
                
    return answer