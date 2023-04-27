package Stacks;


public class Balancedparenthesis {
	
	public static boolean check(String expression) {
		int n=expression.length();
		stackuse<Character> s=new stackuse<>();
		boolean val=false;
		int i=0;
		for(i=0;i<n;i++) {
			char ch=expression.charAt(i);
			if(ch=='('|| ch=='{' || ch=='['){
				s.push(ch);
			}
			else if(ch==')') {
				val=handle(s,'(');
				if(val==false)
					return false;
			}
			else if(ch=='}') {
				val=handle(s,'{');
				if(val==false)
					return false;
			}
			else if(ch==']') {
				val=handle(s,'[');
				if(val==false)
					return false;
			}
		}
		
		if(s.size()==0)
			return val;   

		return false;  // (()--> stack is not empty
	}
	
	public static boolean handle(stackuse<Character> s,char opench) {
		if(s.size()==0)
			return false;   // nothing to pop bcoz closing is extra
		else if(s.top()!=opench)   // last open is not equal to first open
			return false;
		else
			s.pop();
		return true;
	}

	public static void main(String[] args) {
		String input="())";
		System.out.println(check(input));

	}

}
