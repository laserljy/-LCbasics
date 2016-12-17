public class LC_reverseWord {

	public static String solution1(String s){
		StringBuilder result= new StringBuilder();
		String[] wordArray=s.split("\\s+");   // use regex as delimiter, question, how to have multiple delimiter
		for(int i=wordArray.length-1; i>=0; i--){   // !!! common mistake of mine: array has the length parameter
			result.append(wordArray[i]+" ");									 // not the length() method. Why? B/c array length is fixed!!!
		}	
		System.out.println(result.toString());
		return result.toString();
	}
	
	public static void solution2(char[] s){
		reverse(s, 0, s.length-1); // don't need to write s = reverse(s, 0, s.length) since you are doing inline manipulation.
		for(int i=0, j=0; j<s.length; j++){
			if(s[j]==' '){  // Question: how can I use \\s and == together? 
				reverse(s, i, j-1);
				i=j+1;
			}
			else if(j==s.length-1){ // last word does NOT has the following space, special case special op
				reverse(s, i, j);
			}
		}
		//return s;
	}
	
	private static void reverse(char[] s, int p, int q){  // I have a problem when dealing with String class using in-line solution, 
		while(p<=q){                                // b/c String is immutable. I found the answer in the book, that the input
			char temp;								// is actually a char array, which makes sense.
			temp=s[p];
			s[p]=s[q];
			s[q]=temp;
			p++; q--;    // !!! no return here, since you are doing inline manipulation.
		}
	}
	public static void main(String[] args) {
		String s1="I want to write nice code.";
		solution1(s1);
		char[] s2= s1.toCharArray();
		solution2(s2);
		System.out.println(s2);  // directly print a char array?? Yes!!! And yon can has ONLY s2 as the input
		// 因为输出流System.out是PrintStream对象，PrintStream有多个重载的println方法
		// 其中一个就是public void println(char[] x)，直接打印字符数组的话，不像int[]等其他数组
		// 它会直接调用这个方法来打印，因而可以打印出数组内容，而不是地址。
		// !!! if you use System.out.println(s2.toString()) or System.out.println("s2: " + s2) 
		// it will print the address:       array name w/o index is the starting address, for both case
		
		// test println(char array)
		String a="how are you";
		char[] b = a.toCharArray();
		System.out.println(b); //

	}
}

// reflection:
// 1, solution1, brute force, need to use String.split(regex) !!! and use StringBuilder(much better than string adding)
// 2, solution2, the idea for solving this problem is inspiring. reverse twice, 1st global reverse, 2nd local word-base reverse
// this method has space complexicity O(1), just inline manipulation, no extra space. Time complexicity O(2N)=O(N)



