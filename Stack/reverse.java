package Stacks;
import java.util.Stack;
public class reverse {
 
		public static void reverseStack(Stack<Integer> stack) {
			if(stack.size()==0)
	            return;
	        else{
	            int x=stack.pop();
	            reverseStack(stack);
	            insertatbottom(x,stack);
	        }	
		}
		
		public static void insertatbottom(int x,Stack<Integer> stack){
	        if(stack.size()==0){
	            stack.push(x);
	            return;
	        }
	        else{
	            int a=stack.pop();
	            insertatbottom(x,stack);
	            stack.push(a);
	        }    
	    }

	public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		reverseStack(s);
		while(!s.isEmpty()) {
			System.out.print(s.pop()+ " ");
		}

	}

}
