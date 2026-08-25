class Solution {
    public boolean isValid(String s) {
        Stack<Character> sol = new Stack<>();
        if(s.length()<=1 || s.length()%2 != 0) return false;
        for(Character ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                sol.push(ch);
            }
            if(ch == ')'){
                if(!sol.isEmpty() && sol.peek() == '('){
                    sol.pop();
                }
                else{
                    return false;
                }
            }
            if(ch == '}'){
                if(!sol.isEmpty() && sol.peek() == '{'){
                    sol.pop();
                }
                else{
                    return false;
                }
            }
            if(ch == ']'){
                if(!sol.isEmpty() && sol.peek() == '['){
                    sol.pop();
                }
                else{
                    return false;
                }
            }
        }
        return sol.isEmpty();
    }
}
