public class LC_isPalindromeNumNoExSpace {

	public static boolean isPalindromeNum(int input){
		if(input<0) return false;
		else if(input>=0 && input<10) return true;
		else{
			int len=getLen(input);
			int fixLen=len;
			for(int i=0; i<(fixLen/2); i++){
				int right = input % ((input/10)*10);
				int devidor = (int)Math.pow(10, len-1);
				int left =input/devidor;
				if(right!=left) return false;
				input %= (right)*devidor;
				input /= 10;
				len-=2;
			}
			return true;
		}
	}
	
	public static boolean isPalindromeNum2(int input){  // using getDigit() function
		if(input<0) return false;
		else if(input>=0 && input<10) return true;
		else{
			int len=getLen(input);
			System.out.println(len);
			for(int j=1; j<=(len/2);j++){ // j should start from 1 here for index of digit from right
//				int right =getDigit2(input, j);
//				int left =getDigit2(input,len+1-j);
				if(getDigit2(input, j)!=getDigit2(input,len+1-j)) return false;
			}
			return true;
		}
	}
	
	public static int getDigit(int x, int i){
		int digit;
		int devidor1=(int)Math.pow(10,i-1);
		int devidor2=(int)Math.pow(10,i);
		digit = (x/devidor1) % ((x/devidor2)*10);
		return digit;
	}
	// spent long time in getting the highest digit, problem devidor2 is too big that x/devidor is zero
	// another simple way, also correct the way I think about getting the unit digit, it is actually super 
	// straigtforward and easy, you have read and implement these basic techs in mind.
	// see getDigit2(int x, int i)
	
	public static int getDigit2(int x, int i){
		return (x/(int)Math.pow(10, i-1)) % 10;
	}
	// spent long time in getting the highest digit.
	
	
	
	public static int getLen(int a){
		int len=0;
		while(a!=0){
			len++;
			a=a/10;
		}
		return len;
	}
	
	
	public static void main(String[] args) {
		int a = -6; 
		int b =  6;
		int c = 123454321;
		
		if(isPalindromeNum(a)) System.out.println("a is Palindrome number.");
		else System.out.println("Nope, a is not a Palindrome number.");
		
		
		if(isPalindromeNum(b)) System.out.println("b is Palindrome number.");
		else System.out.println("Nope, b is not a Palindrome number.");
		
		if(isPalindromeNum2(c)) System.out.println("c is Palindrome number.");
		else System.out.println("Nope, c is not a Palindrome number.");
		
		System.out.println(getDigit2(c, 9));
		
	}

}
