
// Robot can move is direction given in string g is one unit.
// L id left
// R if right
// determine if its path is circular
public class Robotpath {
	
	public static boolean isCircular(String moves) {
		char currdir='N';
		int x=0,y=0;
		for(int i=0;i<moves.length();i++){
			char ch=moves.charAt(i);
			if(ch=='G'){
				x+=currdir=='E'?1:0;
				x+=currdir=='W'?-1:0;
				y+=currdir=='N'?1:0;
				y+=currdir=='S'?-1:0;
			}else{
				if(currdir=='N'){
					if(ch=='L')
						currdir='W';
					else
						currdir='E';
				}else if(currdir=='S'){
					if(ch=='L')
						currdir='E';
					else
						currdir='W';
				}else if(currdir=='E'){
					if(ch=='L')
						currdir='N';
					else
						currdir='S';
				}else{
					if(ch=='L')
						currdir='S';
					else
						currdir='N';
				}
			}			
		}
		
		if ( (x==0 && y==0)  )
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		String s="GRRGGRRGGLLG";
		System.out.println(isCircular(s));
	}

}
