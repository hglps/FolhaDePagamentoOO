package mainpackage;
import java.util.ArrayList;
import java.util.Scanner;
public class Company {
    public static Scanner read = new Scanner(System.in);
    private final static int patternId = 19002100;
    private final static int maxSize = 500;
    ArrayList<Employee> employees = new ArrayList<Employee>(maxSize);
    ///////////rever verify de ID == -1.. sempre vai comecar com 0
    public static void main(String[] args) {
        String password = "admin";
        String reading;
        while(true){
            screenEnterPassword();
            reading = read.nextLine();
            if(reading.equals(password)){
                //start main code
                //add someone with id properly

            }
            else if(reading.equalsIgnoreCase("quit"))
                break;
            else
                System.out.println("\nInvalid Password! Try again!\n");
        }
        screenSystemFinished();


    }

    private static void screenEnterPassword(){
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||Insert password to access payroll system or insert 'quit' to quit the system:||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
          System.out.print("Password: ");
    }
    private static void screenSystemFinished(){
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||System completely finished!|||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }
}
