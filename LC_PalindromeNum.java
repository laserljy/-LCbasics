public class LC_PalindromeNum {
	
	
	// method 1, convert the number to an array of character, so really need to know well about
	// conversion from int to string to char array. There is no direct conversion, but simplified
	public static boolean inPalindromeNum1(int x){
		if(x<0) return false;
		String str_x = Integer.toString(x); //
		//String str_y = String.valueOf(x);
		//System.out.println(str_y);   it is approved that both function works, 
		//Integer.toString(int x) & String.valueOf(int x);
		
		//char[] array_x1 = Character.toChars(x); // not a good idea to directly convert int to array of char
		// it is always workable to go from int to string to array of char
		
		// !!! here is a nice conversion: char[] chars = ("" + i).toCharArray(); 
		// ("" + i) this is so smart that it automatically convert int to array!! then followed with String function
		char[] array_x1= (""+x).toCharArray();
		//System.out.print(array_x1[0]);
		for(char item: array_x1){
			System.out.print(item + ",");
		}
		char[] array_x = str_x.toCharArray();
		int len= array_x.length;  // for char[], length is just a property, not a func.
		for(int i=0; i<(len/2); i++){
			if(array_x[i]!=array_x[len-1-i]) return false;
		}
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
		 if(inPalindromeNum1(1113111)){
			 System.out.println("Yes, it is Palindrome number.");
		 }else System.out.println("Nope it is not Palindrome number.");
	}

}
