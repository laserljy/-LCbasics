public class LC_isPalinNumNoExSpaceQuick {

	public static boolean isPalindrome(int x){
		int len=getLen(x);
		for(int j=1; j<=len/2; j++)
		if(getDigit(x,j)!=getDigit(x, len+1-j)) return false;
		return true;
	}
	
	public static int getDigit(int a, int i){
		return (a/(int)Math.pow(10,i-1))%10;
	}
	
	public static int getLen(int b){
		int len=0;
		if(b>0){
			while(b!=0){
				b/=10;
				len++;
			}	
		}	
		return len;
		
	}
	
	public static void main(String[] args) {
		int a = 123454321;
		int b = 4733174;
		if(isPalindrome(a)) System.out.println("yes");
		else  System.out.println("no");
		if(isPalindrome(b)) System.out.println("yes");
		else  System.out.println("no");
	}

}


// report: finish in 10 minutes, with one bug: j<len/2 --> j<= len/2