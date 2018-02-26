import java.util.*;

public class Crypto{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		System.out.println( text ); 
		String newStr = normalizeText( text );
		System.out.println( newStr );
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
}


