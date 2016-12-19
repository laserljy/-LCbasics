public class LC_atoiSimple {
	
	private static final int maxDiv10=Integer.MAX_VALUE/10;
	public static int solution(String s){
		int len=s.length();
		int sum=0;
		int sign=1;
		int i=0;
		while(i<len && Character.isWhitespace(s.charAt(i))) i++;
		if(i<len && s.charAt(i)=='+') i++;
		else if(i<len && s.charAt(i)=='-'){
			sign=-1;
			i++;
		}
		while(i<len && Character.isDigit(s.charAt(i))){  // exit 1, reaching the end, exit 2, other chars
			int digit = Character.getNumericValue(s.charAt(i));
			if(sum>maxDiv10|| (sum==maxDiv10 && digit>=8)){
				return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;  // exit 3, overflow
			}
			sum=10*sum+digit;
			i++;
		}
		
		return sum*sign;  // if is there is any letters rather than number in the middle, then i stop to grow, you get the value
	}

	
	public static void main(String[] args) {
		System.out.println(solution("+123"));
		System.out.println(solution("-678"));
		System.out.println(solution(""));
		System.out.println(solution("  -923AFAD"));
		System.out.println(solution("dafa"));
	}

}

// key is still the same, you have to define the type of char allow for the i to increase. In this case, they are
// white space, +/-, digit, any other char will end the program and return a value, exit 2 for the while() loop
// exit 3, overflow; exit 3 for the whole program, reach to the end exit1 for while() loop

