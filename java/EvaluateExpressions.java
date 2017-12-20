import java.util.Stack;

public class EvaluateExpressions {
	public static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		else
			return false;
	}
	
	public static int performOperation(char operator, int operand1, int operand2) {
		int result = 0;
		
		switch(operator) {
			case '+':
				result = operand1 + operand2;
				break;
			case '-':
				result = operand1 - operand2;
				break;
			case '*':
				result = operand1 * operand2;
				break;
			case '/':
				result = operand1 / operand2;
				break;
		}
		
		return result;
	}
	public static int evaluatePostfix(char[] expression) {
		Stack<Integer> s = new Stack();
		int result = 0;
		
		for (int i = 0; i < expression.length; i++) {
			if (!isOperator(expression[i])){
				s.push( expression[i] - '0');	//to convert to int
			}
			else {
				int op2 = (int) s.pop();
				int op1 = (int) s.pop();
				
				result = performOperation(expression[i], op1, op2);
				s.push(result);
			}
		}
		
		//Peek returns the top of stack
		return (int) s.peek();
	}
	
	public static int evaluatePrefix(char[] expression) {
		Stack<Integer> s = new Stack();
		int result = 0;
		
		for (int i = expression.length - 1; i >= 0; i--) {
			if (!isOperator(expression[i])){
				s.push( expression[i] - '0');	//to convert to int
			}
			else {
				int op1 = (int) s.pop();
				int op2 = (int) s.pop();
				
				result = performOperation(expression[i], op1, op2);
				s.push(result);
			}			
		}
		
		//Peek returns the top of stack
		return (int) s.peek();
	}
	
	public static void main(String[] args) {
		String postfix = "23*54*+9-"; //should be 17
		String prefix = "-+*23*549";  //should be 17
		
		System.out.println(evaluatePostfix(postfix.toCharArray()));
		System.out.println(evaluatePrefix(prefix.toCharArray()));

	}
}
