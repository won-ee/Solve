def solution(numbers, target):
    global N,answer,used
    answer = 0
    N = len(numbers)
    used = [0] *N

    def dfs(level,cnt,numbers, target):
        global N,answer,used
        
        if level == N:
            if cnt == target :
                answer += 1
            return
                
        dfs(level+1,cnt+numbers[level],numbers, target)
        dfs(level+1,cnt-numbers[level],numbers, target)
          

    dfs(0,0,numbers, target)
        
    return answer