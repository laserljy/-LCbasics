public class LC_ZigZag {

	public static char[][] createZigZag(String s, int n){
		
		int len=s.length();
		// need to know the col_len
		// int col_len =0;  this is the only thing I left to have a perfect solution, after the first try
		
		int col_len=0;
		int row_len=0;
		
		int last_remainder=len%(2*n-2); // need to have boundary of the matrix using the number of last element/len
		int last_block=len/(2*n-2);
		
		//col_len=(last_block+1)*(n-1); // simple setup col_len by block
		// here you can do exact match for col_len, so no waste at all
		
		if(last_remainder>0 && last_remainder<=n) col_len=(last_block)*(n-1)+1;
		else if(last_remainder>n) col_len=(last_block)*(n-1)+1+(last_remainder-n);
		else if(last_remainder==0) col_len=last_block*(n-1); // this is typical when dealing with remainder
		//since remainder increase to the max, then next value is 0, so need to consider this a special case
		
		// notice the corner case, if you have only need one column, n>len, then you can set row_len=n, to save space
		if(n<len) row_len=n;
		else if(n>=len) row_len=len;
		
		char[][] zigzag = new char[row_len][col_len];
		char[] s_array = s.toCharArray();
		
		for(int i=0; i<len; i++){
			int blockNum=i/(2*n-2);
			//System.out.println("tag1:"+blockNum);
			int remainder=i%(2*n-2);
			//System.out.println("tag2:"+remainder);
			if(remainder>=0 && remainder<n){
				int row_index=remainder;
				int column_index=(n-1)*blockNum;
				zigzag[row_index][column_index]=s_array[i];
			}			
			
			else if(remainder>=n && remainder<(2*n-2)){
				int column_index=i-(blockNum+1)*(n-1);
				int row_index=2*(n-1)*(blockNum+1)-i;
				zigzag[row_index][column_index]=s_array[i];
			}
		}
		
		for(int p=0; p<row_len; p++){
			for(int q=0; q<col_len; q++){
				System.out.print(zigzag[p][q]+"-");
			}
			System.out.println();
		}
		
		System.out.println("====The below is the result====");
		for(int p=0; p<row_len; p++){
			for(int q=0; q<col_len; q++){
				if(zigzag[p][q]!='\u0000') System.out.print(zigzag[p][q]+"");  // great!! the null for char!!!
			}
		}
		System.out.println();
		
		String result_str="";
		
		for(int p=0; p<row_len; p++){
			for(int q=0; q<col_len; q++){
				if(zigzag[p][q]!='\u0000') result_str+=zigzag[p][q];  //the way to the append char to String.
																	  //append() for appending string to string
			//but this is so wasteful in space usage, you create new heap space every time + appending.
			}
		}
		System.out.println(result_str);
		
		//==== find the StringBuilder() online ====
		//==== which allow changing the content of the object in the same memory space, w/o creating new space ====
		StringBuilder sb = new StringBuilder();
		
		for(int p=0; p<row_len; p++){
			for(int q=0; q<col_len; q++){
				if(zigzag[p][q]!='\u0000') sb.append(zigzag[p][q]);  //the way to the append char to String.
																	  //append() for appending string to string
			//but this is so wasteful in space usage, you create new heap space every time + appending.
			}
		}
		String str = sb.toString();
		System.out.println(str);
		
		
		//==== similar thing， StringBuffer()  ====
		//==== which allow changing the content of the object in the same memory space, w/o creating new space ====
		StringBuilder sbuffer = new StringBuilder();
		
		for(int p=0; p<row_len; p++){
			for(int q=0; q<col_len; q++){
				if(zigzag[p][q]!='\u0000') sbuffer.append(zigzag[p][q]);  //the way to the append char to String.
																	  //append() for appending string to string
			//but this is so wasteful in space usage, you create new heap space every time + appending.
			}
		}
		String str2 = sbuffer.toString();
		System.out.println(str2);
		
		
		
		
		return zigzag;
	}
	
	public static void main(String[] args) {
		String s = "Ilovecoding.Doyou?";
		createZigZag(s, 4);
		//createZigZag(s, 6);
	}
}


// some reflection: 
// 1, this is essentially a question of how turning a 1-dim array to 2-dim matrix by finding the general transformation algo
// 2, there could some simpler variant, such as S shape or ||| shape, instead of Z shape
// *** basically it is the same idea, think about break the array to block, recursive block
// 3, did not check the boundary for the input for the functions, eg: createZigZag(String s, int n)
// 4, use different ways to concatenate char to String, remember that contont in String cannot be changed
// if changed, new space will be created
