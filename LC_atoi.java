// atoi is a function that converts string to integer. it is build in C++, but not in Java, so we create it
// there are a few conditions need to account for
// 1, get rid of whitespace
// 2, in the iteration through trimmed String, the first index is for sign, so need special op
// 3, the trick or the key thing is overflow problem, when int is out of range. Integer.MAX_VALUE=2147483647; Integer.MIN_VALUE=-2147483648;
// 4, so need to account for that using concise conditions!


public class LC_atoi {
	
	private static final int maxDiv10= Integer.MAX_VALUE/10;
	public static int solution(String s){
		
		s=s.trim();
		//System.out.println(s);
		if(s==null||s=="") return 0;
		
		int sign=1;
		int sum=0;
		int digit=0;
		for(int i=0; i<s.length(); i++){
			if(i==0){
				if(s.charAt(i)=='+') sign=1;     //!! attention, s.charAt(i) returns a char not a String, so use '', not ""
				else if(s.charAt(i)=='-') sign=-1;
				//System.out.println(sign);
			}
			else if(i==s.length()-1 && Character.isDigit(s.charAt(i))){
				digit=Character.getNumericValue(s.charAt(i));
				return sign*(sum*10+digit);
			}
			else{
				// check each char is digit or not?
				//System.out.println("digit once");
				if(Character.isDigit(s.charAt(i))) digit=Character.getNumericValue(s.charAt(i));
				else return sign*sum;  // if not digit;
				
				// check the range of sum is valid
				if(sum>maxDiv10||sum==maxDiv10&&digit>8){
					return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
				}
				sum=sum*10 + digit;
				//System.out.println(sum);
			}
		}
		
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(solution("+123"));
		System.out.println(solution("-678"));
		System.out.println(solution(""));
		System.out.println(solution("   -923"));
		System.out.println(solution("dafa"));
	}
}
