import  java.util.Scanner;
public class InputHelper {
    /*
    *Loops through until the user enters a valid int value
    *Displays error message and asks user to try again until valid input received.
     */
    public static int getInt (Scanner scan, String prompt){
        int num = 0; //eventually returned to user after validation
        boolean done = false;

        System.out.println(prompt);
        do {
            if(scan.hasNextInt()){
                num = scan.nextInt();
                done = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }
    public static int getPositiveNonZeroInt (Scanner scan, String prompt){
        int num = 0; //eventually returned to user after validation
        boolean done = false;

        System.out.println(prompt);
        do {
            if(scan.hasNextInt()){
                num = scan.nextInt();
                if (num > 0){
                    done = true;
                }
            } else {
                System.out.println("Please enter a positive non-zero integer value.");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }
    public static int getRangedInt (Scanner scan, String prompt, int max, int min){
        int num = 0; //eventually returned to user after validation
        boolean done = false;

        System.out.println(prompt);
        do {
            if(scan.hasNextInt()){
                num = scan.nextInt();
                if (max >= num && num >= min){
                    done = true;
                }
            } else {
                System.out.println("Please enter a integer value within the limits.");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }
    public static String getRegExString(Scanner scan, String prompt, String regExPattern){
        String input; //stores string input by user
        boolean done = false;
        System.out.println(prompt);
        do{
            input = scan.nextLine();
            if (input.matches(regExPattern)){
                done = true;
            }else {
                System.out.println("Your input does not match the given format.");
            }
        }while (!done);
        return input;
    }
    public static String getNonZeroLenString (Scanner scan, String prompt){
        String input; //stores string input by user
        boolean done = false;
        System.out.println(prompt);
        do{
            input = scan.nextLine();
            if (!input.isEmpty()){
                done = true;
            }else {
                System.out.println(prompt);
            }
        }while (!done);
        return input;
    }
    public static boolean getYNConfirm (Scanner scan, String prompt){
        String input; //stores string input by user
        boolean done = false;
        boolean yes = false;
        System.out.println(prompt);
        do{
            input = scan.nextLine();
            if (input.equalsIgnoreCase("y")){
                done = true;
                yes = true;
            } else if (input.equalsIgnoreCase("n")) {
                done = true;
            } else {
                System.out.println(prompt);
            }
        }while (!done);
        return yes;
    }
    public static double getDouble (Scanner scan, String prompt){
        double num = 0; //eventually returned to user after validation
        boolean done = false;

        System.out.println(prompt);
        do {
            if(scan.hasNextDouble()){
                num = scan.nextDouble();
                done = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }
    public static double getRangedDouble (Scanner scan, String prompt, int max, int min){
        double num = 0; //eventually returned to user after validation
        boolean done = false;

        System.out.println(prompt);
        do {
            if(scan.hasNextDouble()){
                num = scan.nextDouble();
                if (max >= num && num >= min){
                    done = true;
                }
            } else {
                System.out.println("Please enter a value within the limits.");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }
}