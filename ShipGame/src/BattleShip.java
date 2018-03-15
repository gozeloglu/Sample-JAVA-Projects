import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BattleShip {
    public static void main(String[] args) {
        printingMap();
        Scanner input = new Scanner(System.in);
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

        System.out.println("   0123456789\t");
        for ( i = 0 ; i < 10 ; i++ ) {
            System.out.print( i + " | ");
            for ( j = 0 ; j < 10 ; j++ ) {
                System.out.print(mapArray[i][j]);
            }
            System.out.println(" | " + i );
        }


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
}
