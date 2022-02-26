import java.util.*;


public class ConstantSpaceRandom{
	static int count = 0;
	static int result = 0;


	public static void main(String[] args){
		int stream[] = {1, 2, 3, 4};
        int n = stream.length;
        for(int i = 0; i < n; i++){
        	System.out.println("i="+(i+1)+" random value is -> "+selectRandomInt(stream[i]));
        }
	}

	public static int selectRandomInt(int num){
		count++;

		if(count == 1){
			result = num;
		} else {
			System.out.println("Here");
			Random rand = new Random();
			int position = rand.nextInt(count);

			if(position == count - 1){
				result = num;
			} 
		}
		return result;
	}
}