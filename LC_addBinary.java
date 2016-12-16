public class LC_addBinary {


	public static int[] reverseAndToInt(String s){
		int len = s.length();
		int[] result = new int[len];
		char[] ch_array= s.toCharArray();
		for( int i=0; i<len; i++){
			result[i]=Character.getNumericValue(ch_array[len-1-i]); // reserve and parse to int
		}
		return result;
	}
	
	public static String addBinary(int[] a, int[] b){
		
		String result;
		int longerLen= (a.length>b.length?a.length:b.length);
		//System.out.println(longerLen);
		int[] advance = new int[longerLen+1];
		//System.out.println(advance.length);
		//System.out.println(advance[0]);
		//System.out.println(advance[1]);
		//System.out.println(advance[longerLen]);
		
		int[] result_IntArray = new int[longerLen+1];
		
		// have to extend the a and b to length of (longerLen);
		// online suggestion: use ArrayList as the container
		// otherwise establish a new array, I will try this first
		
		int[] aNew = new int[longerLen+1];
		System.arraycopy(a, 0, aNew, 0, a.length);
		//System.out.println(aNew[longerLen]);
		System.out.println(aNew[0]);
		System.out.println(aNew[1]);
		//System.out.println(aNew[longerLen]);
		
		int[] bNew = new int[longerLen+1];
		System.arraycopy(b, 0, bNew, 0, b.length);
		System.out.println(bNew[0]);
		System.out.println(bNew[1]);
		//System.out.println(bNew[longerLen]);

		for(int i=0; i<(longerLen+1); i++){
			int eachAdd= aNew[i]+bNew[i]+advance[i];
			if(eachAdd==0||eachAdd==1) result_IntArray[i]=eachAdd;
			else if(eachAdd==2) {result_IntArray[i]=0; advance[i+1]=1; }
			else if(eachAdd==3) {result_IntArray[i]=1; advance[i+1]=1; }
		} // if the last one is zero, it is okay, we can manipulate later;

		
		StringBuffer sb= new StringBuffer(); 
		for(int i=longerLen; i>=0; i--){  // should be i>=0, not i>0, 0 is your first index!!
			sb.append(result_IntArray[i]);
		}
		result=sb.toString();	
		return result;
	}
	
	public static void main(String[] args) {
		String s1="111110";
		String s2="111";
		int[] x =reverseAndToInt(s1);
		int[] y= reverseAndToInt(s2);
		System.out.println(addBinary(x,y));
	}

}
