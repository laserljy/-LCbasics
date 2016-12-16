public class LC_TwoSumSmartWay {

	public static int[] twoSumSmart(int[] x, int target){
		
		int low=0;
		int high=x.length-1;
		while(low<high){
			int sum=x[low]+x[high];
			if(sum<target) low++;
			else if(sum>target) high--;
			else{
				System.out.println("Found:"+(low+1)+","+(high+1));
				return new int[]{low+1, high+1}; 
			}
			
		}
		System.out.println("Not found");
		return new int[]{0,0};
		//return result;
		
	}
	
	
	public static void main(String[] args) {
		int[] x = {2,3,5,6,9,14,16,19,31};
		twoSumSmart(x, -1);
	}
}

// 1, time complexity O(N), space complexity O(1), so for the easiest way for towSum sorted array.
// 	1) image the numbers as ascending ladder, we start from the low and high, closing to the middle, 
//     Chinese:夹逼法, property, points (low, high) can NOT move back, 
// 	2) I thought about the starting from anywhere in the middle, and expanding to two sides. but the problem is: 
//	   points (low, high) can go back, which means that they cannot have more choice that makes case and coding 
//	   complex, eg： (3, 4) -> (4, 5), both low and high increase.
// 2 Walk to the wall, and found that 夹逼法 was used in validPalindrome(), in case we are not sure about exact index
//   in the array, nor we care about the exact index, what really matters is the two ends both closing to the middle.


