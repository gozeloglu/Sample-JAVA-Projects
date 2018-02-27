import java.util.*;

public class Crypto{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Please write string: ");
		String text = input.nextLine();

		System.out.print("Please enter the shift number: ");
		int shift = input.nextInt();

		System.out.print("Please enter the group size of number: ");
		int groupSize = input.nextInt();

		String result = encryptString( text, shift, groupSize );
		System.out.println( result );
	}

	public static String encryptString( String encyrpted, int shift, int groupSize ){
		String txt = normalizeText( encyrpted );
		String txt2 = caesarify( txt, shift );
		String txt3 = groupify( txt2, groupSize );

		return txt3;
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


	public static String groupify( String text, int perNumber ) {
		String firstString = text.substring(0, perNumber);
		String secondString = text.substring(perNumber, text.length());
		String result = "";

		if ( secondString.length() % perNumber == 0 ) {
			int i;
			for ( i = 0; i < secondString.length(); i += perNumber ){
				result += secondString.substring(i, i+perNumber);
				result += " ";
			}
		}else {
			int i;
			for ( i = 0; i < (secondString.length()-1); i += perNumber){
				result += secondString.substring(i, i+perNumber);
				result += " ";
			}
			result += text.charAt( text.length() - 1 );
			result += 'x';

		}
		return firstString + " " + result;
	}

}
