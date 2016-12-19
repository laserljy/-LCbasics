// given a integer, remove one digit of the two adjacent identical number... it is possible there are mulitple
// identical adjacent numbers in the integer, so you can choose among which you want to delete
// the output should be the largest from all these possibilities
// eg: given 123332253, 
// 1, remove 3, then 12222253
// 2, remove 2, then 12333253
// return 12333253

// this is a G-jia coding sample question.
// @ my solution
// 1, check the positive, or negative, creating a int sign=1/-1 for either case. In main implementation only 
// focus on the positive, since you can use all the method to deal with negative, but find the smallest instead
// 2, iterate the string, find all adjacent identical char, delete the first char, using substring()!! NICE method
// 3, write a function converting string to integer. Actually such a common conversion MUST have the built-in function
//    int a = parseInt(String s); ofcos the s must in the right format, otherwise exception will be thrw out. 
// 4, have a variable result = result>StringToInt(s)? result: StringToInt !! if sign=1;
// 					  result = result>StringToint(S)? StringToInt: result !! if sign=-1;

// some bad ideas I found during I wrote down the step: using Set to contain all the possible result, and iterate again.
// this is not efficient since you iterate one more time. Also you not familiar with the function.

public class LC_GOA1 {

	public static int solution(int a){
		int sign=1;
		int result=0;
		if(a<0) {sign =-1; a=a*(-1); result=Integer.MAX_VALUE;} //!! where problem is fixed
		else if(a==0) return 0;
		
		
		int current=0;
		String s=""+a; // convert a from int to string, yon can use String s=String.valueOf(a) or  String s=Integer.toString(a), to save one space of "" 
		for(int i=1; i<s.length(); i++){ // note that i starts at 1, not 0
			if(s.charAt(i)==s.charAt(i-1))
				current=Integer.parseInt(s.substring(0,i)+s.substring(i+1)); 
				//!!! Interestingly, the maximum for substring() input is s.length(), not s.length()-1 
				if(sign==1) result=result>current?result:current;
				if(sign==-1) result=result<current?result:current; // problem with this code, result starts with 0, smaller than all the positive int
				// !! the solution is add result=Integer.MAX_VALUE; in the beginning within 
		}
		
		if(sign==1) return result;
		if(sign==-1) return result*(-1);
		return 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println(solution(112233));
		System.out.println(solution(-112233));
		System.out.println(solution(115533));
		System.out.println(solution(0));
		System.out.println(solution(123332253));
		
		
		// test case for the max input in String.substring(), it is approved to the length, not the commonly used length-1
		String s="123";
		System.out.println(s.substring(s.length()));
	}

}

// after I figure out the steps, and the built-in method I could use, which takes over 15 mins,
// it really takes 5 mins to code
// thinking is the major part of coding, writing code is just a relative small fraction of the time used
