class RotateArrayByNPlaces {

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		int rotateBy = 2;
		int n = arr.length;
		//leftRotate(arr, arr.length, rotateBy);
		//reverse(arr, 0, rotateBy-1);
		//reverse(arr, rotateBy, n-1);
		//reverse(arr, 0, n-1);
		//displayArray(arr);


		rightRotate(arr, arr.length, rotateBy);
		

	}

	public static void displayArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void reverse(int[] arr, int start, int end){
		while(start < end){
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
	}

	public static void leftRotate(int[] arr, int n, int rotateBy){

		int[] arr2  = new int[rotateBy];
		displayArray(arr);

		if(rotateBy >= n){
			rotateBy = rotateBy % arr.length;
		}

		if(rotateBy == 0){
			System.out.println("No rotation needed!");
		} else{
			for(int i=0; i<rotateBy; i++){
				arr2[i] = arr[i];
			}

			for(int i=rotateBy; i<n; i++){
				arr[i-rotateBy] = arr[i];
			}

			for(int i=n - rotateBy; i<n; i++){
				arr[i] = arr2[i-(n - rotateBy)];
				
			}			
		}


		displayArray(arr);
	}

	public static void rightRotate(int[] arr, int n, int rotateBy){

		int[] arr2  = new int[rotateBy];
		displayArray(arr);

		if(rotateBy >= n){
			rotateBy = rotateBy % arr.length;
		}

		if(rotateBy == 0){
			System.out.println("No rotation needed!");
		} else{
			for(int i=0; i<rotateBy; i++){
				arr2[i] = arr[(n-rotateBy)+i];
			}
			displayArray(arr2);

			for(int i=rotateBy; i>=0; i--){
				
				arr[i+rotateBy] = arr[i];
			}
			displayArray(arr);

			for(int i=0; i<rotateBy; i++){
				arr[i] = arr2[i];
				
			}			
		}


		displayArray(arr);
	}
}