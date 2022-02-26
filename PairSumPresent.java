import java.util.*;

/*Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?*/

class PairSumPresent{
	public static void main(String[] args){
		int[] data = {10,15,3,7,21,5,9,1};
		int pairSum = 4;
		boolean flag  = false;
		String indices = "";

		Map<Integer, String> isPairPresent = new HashMap<>();
		for(int i=0; i<data.length; i++){
			if(isPairPresent.containsKey(data[i])){
				indices = isPairPresent.get(data[i]).split("_")[1]+","+i;
				System.out.println("Pair is present in array -> ("+data[i]+","+isPairPresent.
					get(data[i]).split("_")[0]+")");
				System.out.print("The indices are "+indices);
				flag = true; 
				break;
			} else {
				isPairPresent.put(pairSum - data[i], String.valueOf(data[i])+"_"+i);
			}
		} 
		if(!flag){
			System.out.println("Pair not found in array");
		}
	}
}