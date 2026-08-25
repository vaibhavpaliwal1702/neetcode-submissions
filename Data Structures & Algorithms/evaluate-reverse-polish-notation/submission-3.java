class Solution {
    public int evalRPN(String[] tokens) {
        int a;
        int b;
        Stack<Integer> sol = new Stack<>();
        for(String ch : tokens){
            if(ch.equals("+")){
                a = sol.pop();
                b = sol.pop();
                a = a+b;
                sol.push(a);
            }
            else if(ch.equals("-")){
                a = sol.pop();
                b = sol.pop();
                sol.push(b - a);
            }
            else if(ch.equals("*")){
                a = sol.pop();
                b = sol.pop();
                a = a*b;
                sol.push(a);
            }
            else if(ch.equals("/")){
                a = sol.pop();
                b = sol.pop();
                sol.push(b/a);
            }
            else{
                sol.push(Integer.parseInt(ch));
            }

        }
        return sol.pop();
    }
}
