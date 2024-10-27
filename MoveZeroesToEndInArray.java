class MoveZeroesToEndInArray {

	public static void main(String[] args){
		int[] arr = {1,0,2,3,2,0,0,4,5,1};
		int n = arr.length;
		int[] outputArr = new int[n];
		int j = 0;

		// displayArray(arr);

		// for(int i=0; i<n; i++){
		// 	outputArr[i] = 0;
		// }

		// for(int i=0; i<n; i++){
		// 	if(arr[i] != 0){
		// 		outputArr[j] = arr[i];
		// 		j++;
		// 	}
		// }

		// displayArray(outputArr);

		moveZeroesToTheEndOptimized(arr);

	}
	public static void displayArray(int[] arr){
			for(int i=0; i<arr.length; i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
	}

	public static void moveZeroesToTheEndOptimized(int[] arr){
		int temp = 0;
		int zeroPointer = -1;

		displayArray(arr);
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 0){
				zeroPointer = i;
				break;
			}
		}

		if(zeroPointer == -1){
			System.out.println("No zero elements");
		} else{



		for(int i=zeroPointer+1; i<arr.length; i++){
			if(arr[i] != 0){
				temp = arr[i];
				arr[i] = arr[zeroPointer];
				arr[zeroPointer] = temp; 
				zeroPointer++;
			}	
		}

		displayArray(arr);
		}
	}

}


 