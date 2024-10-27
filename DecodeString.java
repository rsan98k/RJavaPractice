import java.util.*;
import java.lang.*;

/*Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, 
count the number of ways it can be decoded.

For example, the message '111' would give 3, since it 
could be decoded as 'aaa', 'ka', and 'ak'.*/

public class DecodeString{
	public static void main(String[] args){
		String codedString = "123457";
		String lastCharOfString = "";
		Map<Integer, Character> alphabetVsNumber = new HashMap<>();
		getAlphabetVsNumberMap(alphabetVsNumber);
		//System.out.println(Arrays.asList(alphabetVsNumber));

		if(codedString.length() % 2 == 0){
			lastCharOfString = codedString.substring(codedString.length()-1);
			System.out.println(lastCharOfString);
		}
		for(int i=0; i<codedString.length(); i=i+2){
			System.out.println(codedString.substring(i,i+2));
		}
	}

	public static void getAlphabetVsNumberMap(Map<Integer, Character> alphabetVsNumber){
		int j = 1;
		char i;
		for(i='a'; i<='z'; i++){
			alphabetVsNumber.put(j,i);
			j++;
		}
	}
}