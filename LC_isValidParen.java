import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC_isValidParen {
	
	public static boolean isValidParen(String s){ 
		// use HashMap to store pair of parameter, so import java.util.HashMap and java.util.Map in the beginning
		Map<Character, Character> map= null; // initiate parent class... !! Map<char, char> is not allow, only Map<Character, Character> 
		map = new HashMap<Character, Character>(); // use sub class object to instantiate the parent class;
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		boolean tag=false;
		// Use Stack to store the string, since Stack perfectly satisfy the the requirement.
		Stack<Character> sStack= new Stack<Character>();

		char[] sArray =s.toCharArray();
		Character[] sCharacterArray= new Character[sArray.length];
		for (int i=0; i<sArray.length; i++){
			sCharacterArray[i] = new Character(sArray[i]);
		}
		
		for (Character item:sCharacterArray){
			if(map.containsKey(item)) {sStack.push(item); tag=true;}
			else if(map.containsValue(item)&&(item.compareTo(map.get(sStack.peek()))==0)) sStack.pop();
			else if(map.containsValue(item)&&(item.compareTo(map.get(sStack.peek()))!=0)) return false;
		}
	
		if(sStack.empty()&&tag) return true;
		else return false;

	}
	
	
	
	
	public static void main(String[] args) {
		
		String s1="{}[]()";
		String s2="{[[)]}";
		String s3="";  // problem, so I add a tag! smart!!
		
		if(isValidParen(s1)) System.out.println("Yes");
		else System.out.println("No");
		if(isValidParen(s2)) System.out.println("Yes");
		else System.out.println("No");
		if(isValidParen(s3)) System.out.println("Yes");
		else System.out.println("No");
		
	}

}

// conclude:
// 1. Using map for storing matching data (essentially pairs of data) is convenient and SCALABLE!!
// I think about using ACSii code for comparing, that may end up with easy code, but the algorithm is not scalable to 
// more cases. So this is something nice
// 2. Things about using container: you have to use classes as type, such String, Character, Integer. char or int doese NOT work
// because of this, when comparing class, you cannot use == anymore, have to use compareTo() method.
// 3. For differentiate the "always empty" and "not empty, back to empty", just need to add a tag. Smart.

// 4. common method with Stack, boolean empty, E pop(); E peek(); E push(); common initialization 
// import java.util.Stack; (in the beginning)... Stack<Character> stack1= new Stack<Character>();
// 5. for HashMap<K,V>, as well need to import 2 class (which means parent class and sub class initialization)
// Map<Character, Character> map= null;
// map = new HashMap<Character, Character>;




