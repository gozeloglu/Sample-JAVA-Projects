import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class BattleShip {
    public static void main(String[] args) {
        printingMap();
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        char mapArray[][] = new char[10][10];
        ArrayList<Integer> x_Coordinate = new ArrayList<Integer>();
        ArrayList<Integer> y_Coordinate = new ArrayList<Integer>();
        int i, j, x_axis, y_axis;
        System.out.println("Deploy your ships: ");

        /* This loop initialized space to all indexes.*/
        for ( i = 0 ; i < 10 ; i++ ) {
            for ( j = 0 ; j < 10 ; j++ ) {
                mapArray[i][j] = ' ';
            }
        }

        /*  Takes input from user to put user's ships*/
        for ( i = 1 ; i < 6 ; i++ ) {
            System.out.print("Enter X coordinate for your " + i + ". ship: ");
            x_axis = input.nextInt();
            if ( x_Coordinate.contains(x_axis) ) {
                while ( x_Coordinate.contains(x_axis ) || x_axis > 9 ) {
                    System.out.print("Enter X coordinate for your " + i + ". ship: ");
                    x_axis = input.nextInt();
                }
            }
            else {
                x_Coordinate.add(x_axis);
            }
            System.out.print("Enter Y coordinate for your " + i + ". ship: ");
            y_axis = input.nextInt();
            if ( y_Coordinate.contains(y_axis) ) {
                while ( y_Coordinate.contains(x_axis) || y_axis > 9 ) {
                    System.out.print("Enter Y coordinate for your " + i + ". ship: ");
                    y_axis = input.nextInt();
                }
            }
            else {
                y_Coordinate.add(y_axis);
            }
            mapArray[x_axis][y_axis] = '@';
        }

       printingMap(mapArray);

        for ( i = 0 ; i < 5 ; i++ ) {
            int random_computer_x = rand.nextInt(10 - 0) + 0;
            int random_computer_y = rand.nextInt(10 - 0) + 0;
            if ( mapArray[random_computer_x][random_computer_y] != '@' ) {
                mapArray[random_computer_x][random_computer_y] = 'c';
            }
            else {
                while ( mapArray[random_computer_x][random_computer_y] == '@' ) {
                    random_computer_x = rand.nextInt(10 - 0) + 0;
                    random_computer_y = rand.nextInt(10 - 0) + 0;
                }
                mapArray[random_computer_x][random_computer_y] = 'c';
            }
        }
        printingComputerShips();
        printingMap(mapArray);
        Battle(mapArray);

    }

    /* This method prints out the first messages of the game */
    public static void printingMap() {
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println("Right now, the sea is empty.");
        System.out.println("   0123456789\t");
        int i;
        for ( i = 0 ; i < 10 ; i++) {
            System.out.println( i + " | \t\t | " + i);
        }
        System.out.println("   0123456789\t");
    }
    public static void printingComputerShips() {
        System.out.println("Computer is deploying ships");
        int i;
        for ( i = 1 ; i < 6 ; i++ ) {
            System.out.println( i + ". ship DEPLOYED");
        }
    }


    /* Prints out the map */
    /* Coordinates comes from the 2D array*/
    public static void printingMap(char Array[][]) {
        int x, y;
        System.out.println("   0123456789\t");
        for ( x = 0 ; x < 10 ; x++ ) {
            System.out.print( x + " | ");
            for ( y = 0 ; y < 10 ; y++ ) {
                if ( Array[x][y] != 'c' ) {
                    System.out.print(Array[x][y]);
                }
            }
            System.out.println(" | " + x );
        }
        System.out.println("   0123456789\t");
    }

    public static void Battle(char array[][]) {
        ArrayList<Integer> ArrayGuees = new ArrayList<Integer>();
        Scanner guess = new Scanner(System.in);
        Random ComGuess = new Random();
        int computerShip = 5;
        int userShip = 5;
        int counter = 0;
        int x_guess, y_guess;
        while ( computerShip != 0 && userShip != 0 ) {
            if ( counter % 2 == 0 ) {
                System.out.println("YOUR TURN");
                System.out.print("Enter X coordinate: ");
                x_guess = guess.nextInt();
                System.out.print("Enter Y coordinate: ");
                y_guess = guess.nextInt();
                if ( array[x_guess][y_guess] == 'c') {
                    System.out.println("Boom! You sunk the ship!");
                    array[x_guess][y_guess] = '!';
                    computerShip--;
                }
                else if ( array[x_guess][y_guess] == '@' ) {
                    System.out.println("Oh no, you sunk your own ship :(");
                    array[x_guess][y_guess] = 'X';
                    userShip--;
                }
                else if ( array[x_guess][y_guess] == ' ') {
                    System.out.println("Sorry, you missed");
                    array[x_guess][y_guess] = '-';

                }
                printingMap(array);
                System.out.println("Your ships: " + userShip + " | " + "Computer ship: " + computerShip);
                System.out.println("--------------------------------------------------------------------");
                counter++;
            }

            else if ( counter % 2 == 1 ) {
                System.out.println("COMPUTER'S TURN");
                x_guess = ComGuess.nextInt(10 - 0) + 0;
                y_guess = ComGuess.nextInt(10 - 0) + 0;
                if ( array[x_guess][y_guess] == '@' ) {
                    System.out.println("The Computer sunk one of your ships!");
                    array[x_guess][y_guess] = 'X';
                    userShip--;
                }
                else if ( array[x_guess][y_guess] == 'c' ) {
                    System.out.println("The Computer sunk one of its own ships");
                    array[x_guess][y_guess] = '!';
                    computerShip--;
                }
                else if (array[x_guess][y_guess] == ' ') {
                    System.out.println("Computer missed");
                    array[x_guess][y_guess] = 'X';
                }
                printingMap(array);
                System.out.println("Your ships: " + userShip + " | " + "Computer ship: " + computerShip);
                System.out.println("--------------------------------------------------------------------");
                counter++;

            }
        }
        if ( userShip == 0 ) {
            System.out.println("Your ships: " + userShip + " | " + "Computer ship: " + computerShip);
            System.out.println("No! you lost the battle!");
        }
        else if ( computerShip == 0 ) {
            System.out.println("Your ships: " + userShip + " | " + "Computer ship: " + computerShip);
            System.out.println("Hooray! You win the battle :)");
        }
    }
}
