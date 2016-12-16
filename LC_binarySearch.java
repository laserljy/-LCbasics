// java code for binary search in a sort array of int
// this is before implementing the twoSum solution for the sorted Array
// basically, the the towSum problem is essentially the search problem
// given a target and a number(array[i]), search for the (target-array[i])

public class LC_binarySearch {
	
	public static int binarySearch(int[] a, int target){
		int result=0;
		if(target>a[a.length-1]||target<a[0]) {System.out.println("Not in range"); return result;}
		else if(target==a[a.length-1]) {System.out.println("Found"); return result=a[a.length-1];}
		else if(target==a[0]) {System.out.println("Found"); return result=a[0];}
		else{
			for(int i=0; i<a.length; i++){
				int low=i; 
				int high=a.length-1; 
				int middle;
				while(low<(high-1)){
					int remainder=(low+high)%2;
					if(remainder==0) middle=(low+high)/2;
					else middle=(low+high+1)/2;
					
					if(target==a[middle]) {System.out.println("Found"); return result=a[middle];}
					else if(target>a[middle]) low=middle;
					else high=middle;
				}
			}
			
			System.out.println("Not found");
			return result;
		}
	}
	
	public static void main(String[] args) {
		int[] a={1,3,6,7,12,32,54,93};
		binarySearch(a, 2);
		binarySearch(a, 5);
		binarySearch(a, 12);
		binarySearch(a, 32);
		binarySearch(a, 34);
		binarySearch(a, 132);
	}

}
