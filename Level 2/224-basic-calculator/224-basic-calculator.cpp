// This is Infix Evaluation of a expression containing digits 0-9, spaces, +, -, *, /. 
// Same Code can be used to solve Leetcode: Basic Calculator I, Basic Calculator II, Basic Calculator III.

// If the infix expression contains unary operators like ^, log, !, then their precedence will be highest, and their associativity is right to left.
// For evaluation of right to left associativity, the precedence of unary (^) operator outside stack is one more than precedence of unary operator (^) inside stack, so that
// right mose unary operator is evaluated first while popping them. (See Abdul Bari Video for reference).

class Solution {
public:
    long applyOp(long a, long b, char op) {
        long out = 0;
        
        switch(op)
        { 
            case '+': out = a + b; break;
            case '-': out = a - b; break;
            case '*': out = a * b; break;
            case '/': out = a / b; break;
        }
        return out;
    }
    
    long precedence(char op) 
    {
        if(op == '+' || op == '-') return 1;
        else if (op == '*' || op == '/') return 2;
        else return 0;
    }
    
    string refine(string str)
    {
        string s = "0+";
        
        for(int i=0; i<str.size(); i++)
        {
            if((str[i] >= '0' && str[i] <= '9') || str[i] == '(' || str[i] == ')')
                s.push_back(str[i]);
            
            else if(str[i] == '+')
            {
                if(s.back() == '+' || s.back() == '-' || s.back() == '(') 
                    continue;
                
                else s.push_back(str[i]);
            }
            else if(str[i] == '-')
            {
                if(s.back() == '(')
                    s = s + "0-";
                else if(s.back() == '+')
                    s[s.size() - 1] = '-';
                else if(s.back() == '-')
                    s[s.size() - 1] = '+';
                else s.push_back(str[i]);
            }
            else if(str[i] == '*' || str[i] == '/')
                s.push_back(str[i]);
        }
        return s;
            
    }
    int calculate(string str) 
    {
        string s = refine(str);
        
        stack<long> nums;
        stack<char> ops;
        
        for(int i=0; i<s.size(); ++i) 
        {
            char ch = s[i];
            
            if(isdigit(ch)) 
            {
                long num = 0;
                
                while(i<s.size() && isdigit(s[i])) {
                    num = (num * 10ll) + (s[i] - '0');
                    ++i;
                }
                nums.push(num);
                --i;
            }
            
            else if(ch == '(') ops.push(ch);
            
            else if(ch == ')') 
            {
                while(!ops.empty() && ops.top() != '(') 
                {
                    long num2 = nums.top();
                    nums.pop();
                    long num1 = nums.top();
                    nums.pop();

                    long out = applyOp(num1, num2, ops.top());
                    ops.pop();
                    nums.push(out);
                }
                
                ops.pop(); // Pop left bracket
                
            }
            
            else 
            { // Operator
                while(!ops.empty() && precedence(ops.top()) >= precedence(ch)) {
                    long num2 = nums.top();
                    nums.pop();
                    long num1 = nums.top();
                    nums.pop();

                    long out = applyOp(num1, num2, ops.top());
                    ops.pop();
                    nums.push(out);
                }
                ops.push(ch);
            }
        }
        
        while(!ops.empty()) 
        {
            long num2 = nums.top();
            nums.pop();
            long num1 = nums.top();
            nums.pop();

            long out = applyOp(num1, num2, ops.top());
            ops.pop();
            
            nums.push(out);
        }
        
        return nums.top();
    }
    
    
};