class RotateArrayKPlaces {


	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		int firstElement = arr[0];
		displayArray(arr);
		for(int i=1; i<arr.length; i++){
			arr[i-1] = arr[i];
		}

		arr[arr.length-1] = firstElement;
		displayArray(arr);
	}

	public static void displayArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}



}