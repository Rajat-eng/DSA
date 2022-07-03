package Stacks;
import java.util.Stack;
public class Sort {
	
  public static Stack<Integer> sortStack(Stack<Integer> s) {
	  if(!s.isEmpty()){
          int x=s.pop();
          sortStack(s);
          insertinorder(x,s);
      }
      return s;
	}
  public static void insertinorder(int x,Stack<Integer> s) {
	  if(s.size()==0 || x>s.peek()) {
		  s.push(x);
		  return;
	  }else {
		  int a=s.pop();
		  insertinorder(x, s);
		  s.push(a);
	  }  
  }
  
	public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
		s.push(1);
		s.push(3);
		s.push(2);
		Stack<Integer> p=sortStack(s);
		while(!p.isEmpty()) {
			System.out.print(s.pop()+ " ");
		}
	}

}
