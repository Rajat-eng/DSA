
public class removeduplicateconsecutives {
	public static String removeConsecutiveDuplicates(String str) {
		String ans="";
		ans+=str.charAt(0);             
		int i=1,j=0;
		for(i=1;i<str.length();i++)
		{
			if(str.charAt(i)==ans.charAt(j)){
				continue;
			}
			else
			{
				j++;
				ans+=str.charAt(i);
			}		
		}
		return ans;
	}

	public static void main(String[] args) {
		String str="aabbcdd";
		System.out.println(removeConsecutiveDuplicates(str));
	}
  }
