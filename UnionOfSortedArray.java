import java.util.*;

class UnionOfSortedArray {

	public static void main(String[] args){
		System.out.println();
		System.out.println();
		System.out.println();
		int[] arr1 = {1,1,2,3,4,5};
		int[] arr2 = {2,3,4,4,5,6,6};
		displayArray(arr1);
		displayArray(arr2);
		union(arr1, arr2);
		System.out.println();
		System.out.println();
		System.out.println();
	}


	public static void union(int[] arr1, int[] arr2){
		System.out.println("Below is the union array");
		int i=0; 
		int j=0;
		int len1 = arr1.length;
		int len2 = arr2.length;
		List<Integer> union = new ArrayList<>();

		while(i<len1 && j<len2){
			if(arr1[i] <= arr2[j]){
				if(union.size() == 0 || !union.contains(arr1[i])){
					union.add(arr1[i]);
				}
				i++;
			} else{
				if(union.size() == 0 || !union.contains(arr2[j])){
					union.add(arr2[j]);
				}
				j++;
			}	
		}

		while(i < len1){
			if(union.size() == 0 || !union.contains(arr1[i])){
					union.add(arr1[i]);
			}
			i++;
		}


		while(j < len2){
			if(union.size() == 0 || !union.contains(arr2[j])){
					union.add(arr2[j]);
				}
				j++;
		}

		displayList(union);

	}


	public static void displayArray(int[] arr){
			for(int i=0; i<arr.length; i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
	}

	public static void displayList(List<Integer> l){
			for(int i=0; i<l.size(); i++){
				System.out.print(l.get(i)+" ");
			}
			System.out.println();
	}

}