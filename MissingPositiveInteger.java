import java.util.*;
import java.lang.*;

/*Given an array of integers, find the first missing positive integer in linear time and constant space. 
In other words, find the lowest positive integer that does not exist in the array. 
The array can contain duplicates and negative numbers as well.
For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.*/

public class MissingPositiveInteger{

	public static void main(String[] args){
		try{
			int stream[] = {6,2,0,1,3,4};
			int sortedArray[] = {};
			int temp = 0;
			int flag = 0;

			displayArray(stream);
			System.out.printf("\n");
			bubbleSort(stream, stream.length);
			displayArray(stream);
			System.out.printf("\n");
			for(int k=0; k<stream.length-1; k++){
				if(stream[k]+1 == stream[k+1]){
					continue;
				} else{
					flag = stream[k]+1;
				}
			}
			System.out.print("First missing positive integer is ");
			if(flag == 0){
				System.out.print(stream[stream.length-1]+1);
			} else {
				System.out.print(flag);
			}
		} catch(Exception e){
			System.out.println(e);
		}
	}

	public static void displayArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}

	public static void bubbleSort(int[] arr, int len){
		if(len == 1){
			return;
		}

		for(int i=0; i<len-1; i++){
			int temp = 0;
			if(arr[i] > arr[i+1]){
				temp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
		}
		bubbleSort(arr, len-1);
	}
}