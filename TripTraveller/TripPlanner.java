import java.util.Scanner;

public class TripPlanner{
	public static void main(String[] args){
		Greetings();
		TravelBudget();
		TimeDifference();
		CountryArea();

	}


	public static void Greetings(){
		System.out.println("Welcome to Vacation Planner");
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name = input.nextLine();
		System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
		String city = input.nextLine();
		System.out.println("Great! " + city + " sounds like a great trip");
		System.out.println("*************\n");
	}

	public static void TravelBudget(){
		Scanner input = new Scanner(System.in);
		System.out.print("How many days are they going to spend in their destination? ");
		int day = input.nextInt();
		System.out.print("What is their total budget for the trip in USD? ");
		double budget = input.nextDouble();
		System.out.print("What is the three letters currency symbol for your travel destination? ");
		String currency = input.next();
		System.out.print("How many " + currency + " are there in 1 USD? ");
		double rate = input.nextDouble();
	
		int hour = day * 24;
		int minute = hour * 60;
		int second = minute * 60;
		double perDay = budget / day;
		double currencyRate = budget * rate;
		double perDayCurrency = currencyRate / day;

		System.out.println("If you are travelling for " + day + " days that is the same as " + hour + " hours or " + minute + " minutes.");
		System.out.println("If you are going to spend $" + budget + " USD that means per day you can spend up to $ " + perDay + " USD.");
		System.out.println("Your total budget in " + currency + " is " + currencyRate + " " + currency + ", which per day is " + perDayCurrency + " " + currency);
		System.out.println("-------------\n");
	}

	public static void TimeDifference(){
		Scanner input = new Scanner(System.in);
		System.out.print("What is the time difference, in hours, between your home and your destination? ");
		int time = input.nextInt();
		int midnight, noon;
		if (time >= 0){
			midnight = time;
			noon = 12 + time;
		}else{
			midnight = 24 - time;
			noon = 12 - time;
		}

		System.out.println("That means that when it is midnight at home it will be " + midnight + ":00 in your travel destination and when it is noon at home it will be " + noon + ":00");
		System.out.println("############\n");
	}

	public static void CountryArea(){
		Scanner input = new Scanner(System.in);
		System.out.print("What is the square area of your destination country in km2? ");
		double area = input.nextDouble();
		double mile = area * 0.38610;
		System.out.println("In miles2 that is " + mile);
		System.out.println("^^^^^^^^^^^^^\n");
	}
}



		
