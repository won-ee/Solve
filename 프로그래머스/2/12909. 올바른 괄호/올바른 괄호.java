import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            char cha = s.charAt(i);
            if(cha == ')'){
                if (stack.isEmpty() || stack.peek()==')'){
                    answer =false;
                    break;
                }
                stack.pop();
                continue;
            }
            stack.push(cha);
        }
        if (!stack.isEmpty()){
            answer = false;
        }
        
        
        return answer;
    }
}