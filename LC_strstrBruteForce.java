public class LC_strstrBruteForce {
	public static int strstr1(String s, String t){
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
	}

	// using for() loop here is a bad idea, since you have two index, and it is not a straightforward iteration from
	// start to end, there are interruption in the middle, such as s.charAt(i)!=t.charAt(j)

	public static int strstr2(String s, String t){
		int index=-1;
		int i=0;
		int j=0;
		while(i<(s.length()-t.length())&&j<t.length()){  // exit3: when j= (t.length())+1, +1 here is from last j++ 
			if(s.charAt(i)==t.charAt(j)){  				 // actually, exit3 is the single thing that decides the result!!		
				i++; j++;								 // this is the killer point to solve the prob and write beautiful code
			}
			else{
				i=i-j+1; j=0;
			}
		}
		
		if(j==t.length()) { // note: not (j==t.length()-1), b/c not since after the exit3, there is one j++
			System.out.println("Found the needle, the index in s is: "+ (i-t.length()) ); // not also i++
			return (i-t.length()); 
		}
		else{
			System.out.println("Did not found the needle.");
			return index;
		}	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="learn to code is learn to think";
		String t="code";
		String t2="coke";
		strstr1(s, t);
		strstr2(s, t);
		strstr2(s, t2);
	}
}


// 1. brutal force method, not the most efficient way
// 2. strstr1 worked, but the coding logic and style is not quite fluent
// 3. strstr2 is more structurally and logically clear. Set up a while loop, check the possible exit situations.
// the 2nd while() loop in strstr1 is redundant and make the program looks bad.
