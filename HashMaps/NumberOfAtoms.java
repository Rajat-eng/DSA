package HashMap;
import java.util.*;

class Pair {

	String monoAtom;
	int count;

	Pair(String monoAtom, int count) {
		this.monoAtom = monoAtom;
		this.count = count;
	}
}

class SortComparator implements Comparator<Pair> {

	@Override
	public int compare(Pair p1, Pair p2) {

		return p1.monoAtom.compareTo(p2.monoAtom);
	}

}


public class NumberOfAtoms {
		
public static String countNumberOfAtoms(String s) {
        
        String formula=s;
		// Map to store the count of atoms.
		HashMap<String, Integer> cntOfAtoms = new HashMap<>();

		// Stack to store the current value of the numeric counter.
		Stack<Integer> st = new Stack<>();

		// Variable to denote the current value of the numeric counter.
		int cnt = 0;

		// Variable to denote the value by which the multiplicities of the elements should be increased.
		int coeff = 1;
		
		// String to store the element name.
		String element = "";

		int pow10 = 1;

		int index = ( (int) formula.length()) - 1;
        
		while (index >= 0) {
			
			System.out.println("current character" +  " " + formula.charAt(index));
 
			// If the current char is a digit, update the value of the cnt variable.
			if (Character.isDigit(formula.charAt(index))) {

				cnt += (formula.charAt(index) - '0') * pow10;
				pow10 *= 10;
				
				System.out.println("cnt" + " " + cnt +  " " + "pow" + " "+ pow10);

			} else if (formula.charAt(index) == ')') {

				// Push the variable cnt to the stack.
				if (cnt == 0) {

					st.push(1);

				} else {

					coeff *= cnt;
					st.push(cnt);

				}

				cnt = 0;
				pow10 = 1;

			} else if (formula.charAt(index) == '(') {
				System.out.println(st.peek());
				coeff /= st.peek();
				st.pop();
				cnt = 0;
				pow10 = 1;

			} else if (Character.isUpperCase(formula.charAt(index))) {

				element += formula.charAt(index);

				// Since we are traversing the string from right to left, we will get the reversed element name.
				StringBuffer sb = new StringBuffer(element);
				sb.reverse();
				element = sb.toString();

				// Update the count of the element in the map.
				if (cnt == 0) {
					if (!cntOfAtoms.containsKey(element))
						cntOfAtoms.put(element, coeff);
					else
						cntOfAtoms.put(element, cntOfAtoms.get(element) + coeff);
				} else {
					if (!cntOfAtoms.containsKey(element))
						cntOfAtoms.put(element, coeff * cnt);
					else
						cntOfAtoms.put(element, cntOfAtoms.get(element) + coeff * cnt);
				}

				element = "";
				cnt = 0;
				pow10 = 1;

			} else {
				element += formula.charAt(index);
			}

			index--;
		}

		ArrayList<Pair> atomsCount = new ArrayList<>();

		for (String key : cntOfAtoms.keySet()) {
			Pair p = new Pair(key, cntOfAtoms.get(key));
			atomsCount.add(p);
		}

		// Sort the vector to get elements in lexicographical order.
		Collections.sort(atomsCount, new SortComparator());

		// String to store the final result.
		String ans = "";

		// Build a string from the arrayList.
		for (Pair atom : atomsCount) {

			String monoAtom = atom.monoAtom;
			int count = atom.count;

			ans += monoAtom;

			if (count > 1) {
				ans += count;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		String s="K4(ON(SO3)2)2";
		String ans=countNumberOfAtoms(s);
		//System.out.println(ans);
	}

}
