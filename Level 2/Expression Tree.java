// Construction
/*************************************************************
    Following is the Binary Tree node structure:

    class BinaryTreeNode {
	char data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(char data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

*************************************************************/
import java.util.*;

public class Solution {
    public static String infixToPostfix(String exp){
        Stack<String> postfix = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i=0; i<exp.length(); i++)
        {
            char ch = exp.charAt(i);

            if(ch == '('){

                operator.push(ch);

            } else if(ch == ')'){

                while(operator.peek() != '(') {
                    char op = operator.pop();
                    performOp(postfix, op);
                }

                operator.pop();

            } else if(ch == '+' || ch == '-' || ch == '/' || ch == '*'){

                while(operator.size() > 0 && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch))
                {
                    char op = operator.pop();
                    performOp(postfix, op);                
                }

                operator.push(ch);

            } else {

                // operand
                postfix.push(ch + "");

            }
        }

        while(operator.size() > 0) {
            char op = operator.pop();
            performOp(postfix, op);
        }

        return (postfix.peek());
    }
    public static int precedence(char op){
        if(op == '+' || op == '-') return 1;
        if(op == '/' || op == '*') return 2;
        return 0;
    }

    public static void performOp(Stack<String> postfix, char op){
        String postv2 = postfix.pop();
        String postv1 = postfix.pop();
        postfix.push(postv1 + postv2 + op);
    }

	public static BinaryTreeNode binaryExpressionTree(String s) {	
        String postfix = infixToPostfix(s);
        
        Stack<BinaryTreeNode> stk  = new Stack<>();
        for(int i=0; i<postfix.length(); i++){
            char ch = postfix.charAt(i);
            BinaryTreeNode node = new BinaryTreeNode(ch);
            
            if(ch == '+' || ch == '-' || ch == '/' || ch == '*'){
                if(stk.size() > 0){
                    node.right = stk.pop();
                    node.left = stk.pop();
                }
            }
            stk.push(node);
        }
        return stk.peek();
	}
}

