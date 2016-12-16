public class LC_RemoveDuplicate {

	public static void removeDup(char[] str){
		int len= str.length;
		if(len<2) return;
		
		int p=0;  // 新元素的个数，因为是唯一的，所以也相当于index
		for(int i=0; i<len; i++){
			if(str[i]!='0'){ //新元素的判断条件，其实又问题！！该位置不null，一开始肯定不是，是经过了下面的set null之后才产生的。
				str[p++] = str[i];
				for(int j=i+1; j<len; j++){
					if(str[j]==str[i]) str[j]= '0'; // set null
				}
			}
		}
		str[p]='0'; // 因为p是最后一个特有元素的index + 1， 注意了因为出loop时有++，那么str[p]= character 其实就是用来作为分隔符号。
		// 有这种情况，str最后连续出现1，2，3个字符都是唯一字符，那么他们是不可能不覆写的，在这个方法设定中， 因为设置一个分隔符号，还是很有必要。
	
	}



	public static void main(String[] args) {
		char[] ch_array1 = { 'a', 'b', 'c' }; 
		String str = "abc";
		char[] ch_array2= str.toCharArray();
		System.out.println(ch_array1);
		System.out.println(ch_array2);
		if(ch_array1.equals(ch_array2)) System.out.println("ch_array1 equals to ch_array2");
		else System.out.println("ch_array1 NOT equals to ch_array2");
		
		String str2="aabbccddddddxyz";
		char[] ch_array3=str2.toCharArray();
		
		System.out.println(ch_array3);
		removeDup(ch_array3);
		System.out.println(ch_array3);
	}

}
