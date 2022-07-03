package Stacks;
import java.util.Stack;

public class MaxStack {
	
	Stack<Integer> s;
	int max;
	
	public MaxStack() {
		s=new Stack<Integer>();
		max=-1;
	}
	
	public void push(int value) {
    	if(s.isEmpty()) {
    		s.push(value);
    		max=value;
    		return;
    	}
    	if(value>max) {
    		
    		s.push(2*value-max);
    		max=value;
    	}
    	else {
    		s.push(value);
    	}
	}
	
	public int pop(){
		if(s.isEmpty()) {
			return -1;
		}
		int t=s.pop();
		if(t>max) {
			int temp=max;
			max=2*max-t;
			return temp;
		}
		return t;
	}
	
	public int getMax() {
		if(s.isEmpty()) {
			return -1;
		}
		return max;
	}
	
	public int peek() {
		if(s.isEmpty()) {
			return -1;
		}
		int t=s.peek();
		if(t>max) {
			return max;
		}
		else 
			return t;
	}

 }
