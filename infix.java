package Stacks;

import java.util.Stack;

public class infix {
	
	public static int calculate(String s) {
		
		Stack<Character> operator=new Stack<>();
		Stack<Integer> operand=new Stack<Integer>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch=='(') {
				operator.push(ch);
			}
			else if(Character.isDigit(ch)) {
				operand.push(ch-'0');
			}
			else if(ch=='+'|| ch=='-'||ch=='/'|| ch=='*') {
				while( operator.size()!=0 && operator.peek()!='(' && precedence(ch)<=precedence( operator.peek()) ) {
					char optor=operator.pop();
					int v2=operand.pop();
					int v1=operand.pop();
					int val=operation(v1,v2,optor);
					operand.push(val);
				}
				operator.push(ch);	
			}else if(ch==')') {
				while(operator.peek()!='(') {
					char optor=operator.pop();
					int v2=operand.pop();
					int v1=operand.pop();
					int val=operation(v1,v2,optor);
					operand.push(val);
				}
				operator.pop();
			}
		}
		
		while(!operator.isEmpty()) {
			char optor=operator.pop();
			int v2=operand.pop();
			int v1=operand.pop();
			int val=operation(v1,v2,optor);
			operand.push(val);
		}
		
		return operand.peek();
	}
	
	public static int operation(int v1,int v2, char optor) {
		if(optor=='+') {
			return v1+v2;
		}
		else if(optor=='-') {
			return v1-v2;
		}
		else if(optor=='*') {
			return v1*v2;
		}
		else {
			return v1/v2;
		}
	}
	
	public static int precedence(char ch) {
		if(ch=='+')
			return 1;
		else if(ch=='-')
			return 1;
		else if(ch=='*')
			return 2;
		else 
			return 2;
	}

	public static void main(String[] args) {
		String s="2+(5-6*3/2)";
		System.out.println(calculate(s));

	}

}
