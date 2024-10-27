import java.util.*;

class IntersectionOfSortedArray {

	public static void main(String[] args){
		int[] arr1 = {1,2,2,3,3,4,5,6};
		int[] arr2 = {2,3,3,5,6,6,7};

	}

	public static void intersection(int arr1[], int arr2[]){
		int len1 = arr1.length;
		int len2 = arr2.length; 
		List<Integer> intersect = new ArrayList<>();

		int[] visitedArr = new int[len1 > len2 ? len1 : len2];
		visitedArrLen = visitedArr.length;
		for(int i=0; i<visitedArrLen; i++){
			visitedArr[i] = 0;
		}

		for(int i=0; i<len1; i++){
			
			for(int j=0; j<len2; j++){
				if(arr1[i] == arr2[j] && visitedArr[i] == 0){
					intersect.add(arr1[i]);
					visitedArr[i] = 1;
					break;
				}
				if(arr1[i] < arr2[j]){
					break;
				}
			}
		}
	}
}