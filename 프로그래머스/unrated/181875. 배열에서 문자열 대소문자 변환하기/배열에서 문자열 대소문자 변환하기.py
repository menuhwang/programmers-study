def solution(strArr):
    for i in range(0, len(strArr)):
        if i % 2 == 1:
            strArr[i] = strArr[i].upper()
        else:
            strArr[i] = strArr[i].lower()
    
    return strArr