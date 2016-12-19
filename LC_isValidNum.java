// this is similar to the atoi question, but one more things to consider is the decimal number, one less thing to 
// consider is the overflow issue.

// 1. trim the leading and trailing whitespace
// 2. need to check the first char being + or - is valid
// 3. account for .  ; x.y is not valid only if both x and y are not numeric digits
// 4. The check point!!! return true only a) when iteration to the b) end and flag be true; 
// 	a) condition for move forward: {1. leading continuous whitespace, while(); 2. continuous digits, while(); 3. single decimal, if()
//     4. continuous digits, while(); 5. trailing continuous whitespace, while()  }
//  b) however, all whitespace "         " can reach the end,  "         .        " can reach the end. Thus we need a tag
//     to market the valid situation based on each char. So in addition to approach to the end, we need to as least has a number
//     which means, if we have a digit the flag is turned to true

// the way I wrote atoi is a little different than this one, where I iterate from 1 to last, in atoi I trimmed it first, which takes extra space
// also the way I code here is symmetric, so you should have another version of atoi using the style here.

public class LC_isValidNum {
	
	public static boolean solution(String s){
		boolean flag=false;
		int len=s.length();
		int i=0;
		while(i<len && s.charAt(i)==' ') i++;
		if(i<len && (s.charAt(i)=='+'||s.charAt(i)=='-')) i++;
		while(i<len && Character.isDigit(s.charAt(i))){
			i++;
			flag=true;
		}
		if(i<len && s.charAt(i)=='.') i++;
		while(i<len && Character.isDigit(s.charAt(i))){
			i++;
			flag=true;
		}
		while(i<len && s.charAt(i)==' ') i++;
		return i==s.length() && flag;
	}
	
	
	public static void main(String[] args) {
		String s1="   134141  ";
		System.out.println(solution(s1));
		String s2="-134141";
		System.out.println(solution(s2));
		String s3=" . ";
		System.out.println(solution(s3));
		String s4="1.41";
		System.out.println(solution(s4));
		
	}

}


// finish coding in 5 mins, once you have the fluent idea in mind, it could be really fast
// conclusion and abstraction for the problem: step1: know how many types of char are allowed, if just few, directly use them as checking standard
// if not, use the negation.
// step2, among the allowed types, only digits were VALID, so use a another variable flag to differentiate.

// the frequency is low, but the idea is how to combine different conditions as a single standard (moving forward), and variables to differentiate


