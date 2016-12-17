public class LC_strstrBruteForce {
	public static int strstr(String s, String t){
		int index=-1;
		int i=0;
		int j=0;
		while(i<(s.length()-t.length())&&j<t.length()){
			while((s.charAt(i))==(t.charAt(j))){  // exit 2: !=
				if(j==t.length()-1) {
					System.out.println("Found the needle, the index in s is: "+ (i-t.length()+1) );
					return (i-t.length()+1);  // exit1: exit the whole program
				} 
				i++;
				j++;
			}
			// enter 2
			i=i-j+1;
			j=0;
		}
		return index;
//		for(int i=0; i<(s.length()-t.length()-1); i++){   //note: the for() loop for iteration of i does not suit the purpose here 
//		}
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Iloveyou.";
		String t="you";
		strstr(s, t);
	}
}


// 1. brutal force method, not the most efficient way
// 2. it worked, but the coding logic and style is not quite fluent
