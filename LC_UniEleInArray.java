public class LC_UniEleInArray {
	
	public static boolean isUniqueChars2(String str) {
	    boolean[] char_set = new boolean[256];  // 注意啦： ASCII表的256个字符的value range：0-255
	    for (int i = 0; i < str.length(); i++) {
	      int val = str.charAt(i);
	      if (char_set[val]) return false; // 这个有点屌啊，字符 to 数字 to index，index就相当于前value，对应的是T/F的value
	      char_set[val] = true; 
	    }
	    return true;
	}   // !!! 精华总结： 字符的可以转化为数字，范围是0-255，这个是个知识点，所以可以用array[255]的index与字符做一一对应啊。
		// 在这个基础上，把index对应的value当作标记，可以是这里的T/F，也可以用任何的二元标记，因为就是为了说明出现过还是没有出现过这两种情况嘛。
		// 自己在去写一个int[]来实现，such as hasUniqueElement2(String str)
		// 自己实现了之后，还是发现了一些问题： 就是在 array1_value1 to index, index to array2_value2d的转换过程中要注意。
		// 但是这道题还是吃透了的。
	
	// 还提示了一种用位来表示字符的节省空间的方法。。。暂时没看了。。。
	
	// the above is the copy
	// let me try by myself:
	
	public static boolean hasUniqueElements(String str){
		boolean[] array_boolean = new boolean[256];
		for(int i=0; i<str.length(); i++ ){
			int index=str.charAt(i);
			if(array_boolean[index]==true) return false;
			else array_boolean[index] = true; // 原来if()/else 后面只跟一句command的化，就不需要{}的。
		}
		
		return true;
	}
	
	
	// just repeat for fun, 12.4.16
	public static boolean hasUniqueElement3(String str){
		boolean[] referArray= new boolean[256];
		for(int i=0; i<str.length(); i++){
			int valueToIndex= str.charAt(i);
			if(referArray[valueToIndex]) return false;
			else referArray[valueToIndex]=true;
		}		
		return true;
	}
	
	public static boolean hasUniqueElement2(String str){
		int[] array_value2 = new int[256];
		for (int i=0; i<str.length(); i++){
			int valueToIndex= str.charAt(i);
			System.out.println("array_value2[valueToIndex]:" + array_value2[valueToIndex]);
			if( (array_value2[valueToIndex]-1)==0) return false;
			else array_value2[valueToIndex] = 1;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
/*		String str="ABBCDEFG";
		if(isUniqueChars2(str))
			System.out.println(str +" does NOT have same character.");
		else System.out.println(str + " has same character.");
		
		String str1 = "XYZ";
		if(hasUniqueElements(str1)) System.out.println(str1 + " has unique element.");
		else  System.out.println(str1 + " does NOT have unique element.");

		String str2 ="ABCDD";
		if(hasUniqueElements(str2)) System.out.println(str2 + " has all unique elements.");
		else System.out.println(str2 + " contains duplicated elements");
		System.out.println(hasUniqueElements(str2));
		
		
		// just try the default value of single boolean variable, and variable inside the boolean array.
		// it turns out that you HAVE to initiate boolean variable with a value
		// but not for the boolean array, the default value is false.
		boolean[] A = new boolean[10];
		if(!A[3]){
			System.out.println("default value for \"A\" is: true." );
		}
		
		//int X;
		//System.out.println("X:" + X); // 同样的，单个varialble需要 初始化
		int[] array_value2 = new int[256];
		System.out.println("tag:" + array_value2[2]);// check default value in int array.
		
		
		//int value_char1 = 'a'; // "" is a String type, '' is a character type
		//int value_char2 = 'A'; // "" is a String type, '' is a character type
		//System.out.println("a has a value of "+ value_char1);
		//System.out.println("b has a value of "+ value_char2);
		
*/		
		String str1="abcd";
		if(hasUniqueElement3(str1)) 
			System.out.println(str1 + " has unique elements." );
		else System.out.println(str1 + " does not have unique element.");
		
	}
	
	
}
