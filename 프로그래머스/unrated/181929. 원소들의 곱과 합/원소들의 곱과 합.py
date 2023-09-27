def solution(num_list):
    mul = 1
    sum = 0
    for i in num_list:
        sum += i
        mul *= i
        
    sum *= sum
    
    return 1 if mul < sum else 0