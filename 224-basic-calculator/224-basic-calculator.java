class Solution {
    int performOp(int a, char op, int b) {
        int out = 0;
        
        switch(op)
        { 
            case '+': out = a + b; break;
            case '-': out = a - b; break;
            case '*': out = a * b; break;
            case '/': out = a / b; break;
        }
        return out;
    }
    
    int precedence(char op) 
    {
        if(op == '+' || op == '-') return 1;
        else if (op == '*' || op == '/') return 2;
        else return 0;
    }
    
    public String refine(String s){
        StringBuilder str = new StringBuilder("");
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == ' ') continue;
            if(ch == '+'){
                if(str.length() == 0 || str.charAt(str.length() - 1) == '('){
                    // unary +
                    str.append("0+");
                } else if(str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-')
                    continue;
                else str.append('+');
            }
            
            else if(ch == '-'){
                if(str.length() == 0 || str.charAt(str.length() - 1) == '('){
                    // unary +
                    str.append("0-");
                } else if(str.charAt(str.length() - 1) == '+') 
                    str.setCharAt(str.length() - 1, '-');
                else if(str.charAt(str.length() - 1) == '-')
                    str.setCharAt(str.length() - 1, '+');
                else str.append('-');
            }
            
            else str.append(ch);
        }
        
        return str.toString();
    }
    
    public int calculate(String exp) {
        exp = refine(exp);
        
        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch >= '0' && ch <= '9'){
                int num = 0;
                while(i < exp.length() && exp.charAt(i) >= '0' && exp.charAt(i) <= '9'){
                    num = num * 10 + (exp.charAt(i) - '0');
                    i++;
                }
                
                // operand -> push in operand wali stack
                operand.push(num);
                i--;

            } else if(ch == '('){
                operator.push(ch);

            } else if(ch == ')'){
                while(operator.peek() != '('){
                    int b = operand.pop();
                    int a = operand.pop();
                    char op = operator.pop();
                    operand.push(performOp(a, op, b));
                }

                operator.pop(); // pop opening braces as well
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // operator -> + or - or * or /
                while(operator.size() > 0 && operator.peek() != '(' 
                    && precedence(operator.peek()) >= precedence(ch)){
                    int b = operand.pop();
                    int a = operand.pop();
                    char op = operator.pop();
                    operand.push(performOp(a, op, b));
                }

                operator.push(ch);
            }
        }

        while(operator.size() > 0){
            int b = operand.pop();
            int a = operand.pop();
            char op = operator.pop();
            operand.push(performOp(a, op, b));
        }

        return operand.peek();
    }
}