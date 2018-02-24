import java.util.Scanner;
import java.util.Random;

class OddAndEvens{
	public static void main(String[] args){
		PickOddEven();

	}

	public static void PickOddEven(){
		Scanner input = new Scanner(System.in);

		System.out.println("Let's play a game called \"Odds and Evens\" ");
		System.out.print("What's your name? ");
		String name = input.nextLine();
		System.out.print("Hi " + name + ". Which do you choose? (O)dds or (E)vens? ");
		String choose = input.nextLine();
		if ( (choose).equalsIgnoreCase("O")){
			System.out.println( name + " has picked odds! The computer will be evens!");
		}
		else if ( (choose).equalsIgnoreCase("E")){
			System.out.println( name + " has picked evens! The computer will be odds!");
		}

		System.out.println("--------------------------------");

		//Scanner input = new Scanner(System.in);
		Random rand = new Random();

		System.out.print("How many \"fingers\" do you put out? ");
		int user = input.nextInt();
		int computer = rand.nextInt(6);
		System.out.println("The computer plays " + computer + " \"fingers\"");

		System.out.println("--------------------------------");

		int total = (user + computer);
		int modulus = total % 2;
		System.out.println(user + "  +  " + computer + "  =  " + (user+computer));
		if ( modulus == 1)
			System.out.println( total + " is ..." + "odd!");
		else{
			System.out.println( total + " is ..." + "even!");
		}

		System.out.println("--------------------------------");

		if ( modulus == 1){
			if ( (choose).equalsIgnoreCase("O") ){
				System.out.println("That means " + name + " wins! :)");
			}
			else{
				System.out.println("That means computer wins! :(");
			}
		}
		else if ( modulus == 0){
			if ( (choose).equalsIgnoreCase("E") ){
				System.out.println("That means " + name + " wins! :)");
			}
			else{
				System.out.println("That means computer wins! :(");
			}
		}



	}
}
