def solution(num_list):
    return sum(num_list) if len(num_list) > 10 else mul(num_list)

def mul(num_list):
    result = 1
    for n in num_list:
        result *= n
    
    return result