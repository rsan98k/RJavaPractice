import java.util.*;

class SeconndLargest{


	public static void main(String[] args){
		int[] arr = {1,2,4,7,7,5};
		int minIndex = 0;
		int varToSwap = 0;
		System.out.println("Unsorted Array - ");
		displayArr(arr);
		for(int i=0; i<arr.length-1; i++){
			minIndex = i;
			for(int j=i+1; j<arr.length; j++){
				if(arr[minIndex] > arr[j]){
					minIndex = j;
				}
			}
			//swap
			varToSwap = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = varToSwap;

		}
		System.out.println("Sorted Array - ");
		displayArr(arr);
		int largest = arr[arr.length- 1];
		for(int i=arr.length-2; i>=0; i--){
			if(arr[i]!=largest){
				System.out.println("The second largest element is "+arr[i]);
				break;
			}
		}

		
	}


	public static void displayArr(int[] arr){
		for(int a : arr){
			System.out.print(a+" ");
		}
		System.out.println();
	}
	
}