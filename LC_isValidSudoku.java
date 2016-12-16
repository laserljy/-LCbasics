public class LC_isValidSudoku {

	public static boolean hasUniqueNum(char[] ch_array){
		int len_ch_array = ch_array.length;
		boolean tag_array[]=new boolean[len_ch_array];
		for(int i=0; i<len_ch_array; i++){
			if(ch_array[i]>='1'&&ch_array[i]<='9'){
				int index = ch_array[i]-'1';
				if(tag_array[index]==true) return false;
				else if(tag_array[index]==false) tag_array[index]=true;
			}
		}
		return true;
	}
	
	public static boolean isValidSudoku(char[][] m){
		if(m.length==9 && m[0].length==9){
			for(int p=0; p<9; p++){   // here is for the row, easy
				if(!hasUniqueNum(m[p])) return false;
			}
			
			for(int q=0; q<9; q++){  // here is for the column, need to create a fetchColumn function
				char[] myColumn=fetchColumn(m, q);
				if(!hasUniqueNum(myColumn)) return false;
			}
			
			// here is a little complex job to map the 3x3 to array, need to design a fetchBox function.
			for(int a=0; a<9; a+=3){
				for(int b=0; b<9; b+=3){
					char[] myBox=fetchBox(m, a, b);
					if(!hasUniqueNum(myBox)) return false;
				}
			}
			
			
			
		}
		
		
		else {System.out.println("Yours is not a 9x9 matrix"); return false;}
		
		return true;
	}
	
	public static char[] fetchColumn(char[][] m, int col_index){
		int row_len=m.length;
		char[] result = new char[row_len];
		for(int i=0; i<row_len; i++){
			result[i]=m[i][col_index];
		}
		return result;
	}
	
	public static char[] fetchBox(char[][] m, int a, int b){
		char[] result = new char[9];
		int i=0;
		for(int p=a; p<a+3; p++){
			for(int q=b; q<b+3; q++){
				result[i]=m[a][b];
				i++;	
			}			
		}
		return result;
	}
	
	public static void main(String[] args) {
	//	int a = '3'-'1';     // just make sure int is returned from char calculation.
	//	System.out.println(a);
	//	char[] check ={'1','2','3','4','3'}; // need to know better about checking 
	//	int len1 = check.length;
	//	System.out.println(len1);
	//	if(hasUniqueNum(check)) System.out.println("Yes, unique ele");
	//	else System.out.println("No, not unique ele");
		char[][] m1= new char[9][9];
		m1[0][0]='1';
		m1[1][1]='2';
		m1[2][2]='3';
		m1[3][3]='4';
		m1[4][4]='4';
		if(isValidSudoku(m1)) System.out.println("Yes for Sudoku matrix!");
		else System.out.println("Not a Sudoku matrix!");
		
	}

}



// conclusion/reflection:
// 1, in abstract, the job is: 1, break down the 2D matrix to 1D array; 2, check whether they have unique element
// 2, the 2nd part is easy, you have the function in mind already, boolean hasUniqueNum()
// details is the range of element, the operation between characters
// 3, the 1st part is case by case, getRow is easy, for getColumn I need to have the fetchColumn function, and the 
// range of array, the operation between characters.

// the critical things are how formulate the problem. I find fetchFunction is pretty useful and easy to use. 
// made a logic mistake, need to payAttention: line 19,24,31, if(!hasUniqueNum) return false. I forget !
