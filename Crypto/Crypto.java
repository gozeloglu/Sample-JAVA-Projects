import java.util.*;

public class Crypto{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();

		String newStr = normalizeText( text );
		String newTxt = caesarify(newStr, 1);
		System.out.println( newTxt );
	}

	public static String normalizeText( String str ){
		int i;
		
		for ( i = 0; i < str.length(); i++){
			if ( str.substring(i, i+1).equals("?") || str.substring(i ,i+1).equals("(") || str.substring(i, i+1).equals(")")){
				str = str.replace(str.substring(i, i+1), "");
			}
		}


		str = str.replaceAll("\\W", "");
		str = str.toUpperCase();
		return str;
		
		}

	public static String caesarify(String text, int shift){
		int start = 0;
		shift = shift % 26; 
		
		String result = "";
		
		int i;
		 
		for ( i = 0; i < text.length(); i++){
			int x = (int)text.charAt(i) + shift;
			if ( x <= 90 ){
				char temp = (char)x;
				result += temp;
			}else if ( x > 90 ) {
				x = (x - 90) + 64;
				char temp = (char)x;
				result += temp;
			}
		}

		return result;
	}
}


