import java.util.*;


/*Given an array of integers, return a new array such that each element at index i of the 
new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. 
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?*/

class ProductArray{
	public static void main(String[] args){
		int[] data = {1,2,3,4,5};
		int len = data.length;
		int[] leftArray = new int[len]; //1 _ _ _ _
		int[] rightArray = new int[len]; //_ _ _ _ 1
		int[] finalArray = new int[len];

		leftArray[0] = 1;
		rightArray[len-1] = 1;

		for(int i=1; i<len; i++){ //left array
			leftArray[i] = data[i-1] * leftArray[i-1];
		} 

		printArray(leftArray);
		System.out.println();
		for(int j=len-2; j>=0; j--){ //right array
			rightArray[j] = data[j+1] * rightArray[j+1];
		}
		printArray(rightArray);
		for(int l=0; l<len; l++){
			finalArray[l] = leftArray[l] * rightArray[l];
		}
		System.out.println();
		printArray(finalArray);
	}

	public static void printArray(int[] arr){
		for(int m=0; m<arr.length; m++){
			System.out.print(arr[m]+" ");
		}

	}
}