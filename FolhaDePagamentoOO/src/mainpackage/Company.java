package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    public static Scanner read = new Scanner(System.in);
    private final static int patternId = 19002100;
    private final static int maxSize = 500;
    private static ArrayList<Employee> employees = new ArrayList<Employee>(maxSize);
    private static MyCalendar date = new MyCalendar();
    /*
    * ID = patternID + # + name.susbtring(0,3)
    * */
    public static void main(String[] args) {
        String password = "admin";
        String reading;
        //TODO to loko
        while(true){
            screenEnterPassword();
            reading = read.nextLine();
            if(reading.equals(password)){
                //start main code
                System.out.println("Started main code :)");
                //add someone with id properly
                visualizeOptions();
                while(read.hasNextInt()){
                    int choice;
                    choice = read.nextInt();
                    if(choice == -1) {
                        System.out.println("\n\nPayroll system finished\n");
                        break;
                    }
                    else if(choice == 1){
                        addEmployee();
                    }
                    else if(choice == 2){
                        deleteEmployee();
                    }
                    else if(choice == 3){
                        //TODO cartao de ponto vish
                    }
                    
                    else if(choice == 6){
                        changeRegister();//TODO continuar DAQUI AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
                    }
                    else if(choice == 7) {
                    	payroll();
                    }
                    else if(choice == 11){
                        showAll();
                    }
                    else System.out.println("Invalid option!\nPlease, insert a valid option:\n");

                    visualizeOptions();
                }

            }
            else if(reading.equalsIgnoreCase("quit")){
                screenSystemFinished();
                break;
            }
            else if(!reading.equals(password) && !reading.equalsIgnoreCase("quit"))
                System.out.println("\nInvalid Input! Try again!\n");
        }


    }
    
    private static void payroll() {
    	date.getDate();
    	System.out.println("passou um dia :))");
    	date.setNewDate();
    }

    private static void setUnionCondition(double unionFee, boolean unionMember, int index) {
        if(unionMember){
            employees.get(index).enterUnion(unionFee, employees.get(index).getName(), patternId);
        }
    }

    private static void addEmployee() { //////////////// consertar cloned code
        read.nextLine();
        String name, address, typePayment, wayPayment, partOfUnion;
        boolean unionMember;
        double baseSalary=0 , hourlyRate=0, unionFee = 0;

        System.out.println("/////////////////////////////////////////////////////////////////");
        System.out.print("Insert your name (text entry): "); name = read.nextLine();
        System.out.print("Insert your address (text entry): "); address = read.nextLine();
        System.out.print("Insert the type of payment:\n" +
                "Entry format:\nh - hourly / s - salaried / c - commissioned\nType of payment: ");
        typePayment = read.nextLine();
        if(typePayment.equals("s") || typePayment.equals("c")){
            System.out.print("Insert base salary:\nNumber format: 9999,99\nR$ ");
            baseSalary = read.nextDouble();
            read.nextLine();
        }
        else if(typePayment.equals("h")){
            System.out.print("Insert the hourly rate for this employee:\nNumber format: 9999,99\nR$");
            hourlyRate = read.nextDouble();
            read.nextLine();
        }
        System.out.println("Insert how you want to get paid:\n" +
                "Entry format:\n'mail' - check via mail  /  'check in hands' - check via hands  /  'deposit' - pay via deposit");
        wayPayment = read.nextLine();
        System.out.println("Are you part of any union?\n" +
                "Entry format:\n 'yes' or 'no'\nAnswer:");
        partOfUnion = read.nextLine();
        unionMember = partOfUnion.equals("yes");
        if(unionMember){
            System.out.print("Then, insert the union fee:\nNumber format: 9999,99\n R$ ");
            unionFee = read.nextDouble();
        }
        Employee newEmployee;
        int index;
        String id;
        //////////refatorar para economizar linha esses 3 IF's
        if(typePayment.equals("h")){
            newEmployee = new Hourly(name,address,typePayment, wayPayment, hourlyRate );
            employees.add(newEmployee);
            index = employees.indexOf(newEmployee);
            id = getId(index);
            employees.get(index).setId(id);
            clearScreen();
            setUnionCondition(unionFee,unionMember, index);
            System.out.println("Welcome hourly employee " + employees.get(index).getName() + "!\nID: " + employees.get(index).getId());
        }
        else if(typePayment.equals("s")){
            newEmployee = new Salaried(name, address, typePayment, wayPayment, baseSalary);
            employees.add(newEmployee);
            index = employees.indexOf(newEmployee);
            id = getId(index);
            employees.get(index).setId(id);
            clearScreen();
            setUnionCondition(unionFee,unionMember, index);
            System.out.println("Welcome salaried employee " + employees.get(index).getName() + "!\nID: " + employees.get(index).getId());
        }
        else if(typePayment.equals("c")){
            newEmployee = new Commissioned(name,address, typePayment, wayPayment, baseSalary);
            employees.add(newEmployee);
            index = employees.indexOf(newEmployee);
            id = getId(index);
            employees.get(index).setId(id);
            clearScreen();
            setUnionCondition(unionFee,unionMember, index);
            System.out.println("Welcome commissioned employee " + employees.get(index).getName() + "!\nID: " + employees.get(index).getId());

        }

    }

    private static void deleteEmployee() {
        System.out.println("Insert id: (text entry :: Format - '190021xx@abc' )");
        String id = read.nextLine();
        int index = getIndex(id);
        String name = employees.get(index).getName();
        employees.remove(index);
        System.out.println("Employee " + name + "removed :)");
    }

    private static void changeRegister(){
        System.out.println("Enter ID:");
        String id = read.nextLine();
        int index = getIndex(id);
        int option;
        /* TODO create method in Employee.java */
        while(true){

        screenChangeRegister();
        option = read.nextInt();
        read.nextLine();
        if(option == 0)
            break;
        if(option == 3){
            Employee changedEmployee = null; //TODO talvez de erro
            Employee currEmployee = employees.get(index); //TODO funciona
            System.out.println("\nInsert new type of payment:\n" +
                    "h - hourly / s - salaried / c - commissioned"); String newType = read.nextLine();
            if( newType.equals("h")){
                System.out.print("Insert new hourly rate: (Number format: 9999,99)\nR$ ");
                double hourlyRate = read.nextDouble(); //TODO talvez tenha getchar dps
                changedEmployee = new Hourly(currEmployee.getName(), currEmployee.getAddress(), "h", currEmployee.getWayPayment(), hourlyRate);
                employees.set(index, changedEmployee);
            }
            else if(newType.equals("s") || newType.equals("c")){
                System.out.print("Insert new base salary: (Number format: 9999,99)\nR$ ");
                double baseSalary = read.nextDouble();
                if(newType.equals("s")){
                    changedEmployee = new Salaried(currEmployee.getName(), currEmployee.getAddress(), "s", currEmployee.getWayPayment(), baseSalary);
                }
                else if(newType.equals("c")){
                    changedEmployee = new Commissioned(currEmployee.getName(), currEmployee.getAddress(), "c", currEmployee.getWayPayment(), baseSalary);
                }
                employees.set(index, changedEmployee);
            }
        }


        }// end of while true

    }

    private static void showAll(){
        System.out.println(employees);
    }
    private static void screenChangeRegister () {
        System.out.println("Select the required change:\n" +
                "1 - Name\n" +
                "2 - Address\n" +
                "3 - Type of payment\n" +
                "4 - Method of payment\n" +
                "5 - Part of union\n" +
                "6 - Union fee\n" +
                "0 - Back to main screen");
    }


    private static void screenEnterPassword(){
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||Insert password to access payroll system or insert 'quit' to quit the system:||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
          System.out.print("Password: ");
    }
    private static void visualizeOptions () {
        date.getDate();
        System.out.println("\n------------------------------------------------------------\n" +
                "Insert 1 to ADD a new employee;");
        System.out.println("Insert 2 to REMOVE an employee;");
        System.out.println("Insert 3 to UPDATE POINT CARD of an employee;");
        System.out.println("Insert 4 to UPDATE THE RESULT OF SALES of an employee;");
        System.out.println("Insert 5 to UPDATE SERVICE FEE of an employee;");
        System.out.println("Insert 6 to CHANGE REGISTER of an employee;");
        System.out.println("Insert 7 to RUN TODAY'S PAYROLL;");
        System.out.println("Insert 8 to UNDO OR REDO;");
        System.out.println("Insert 9 to SET PAYMENT SCHEDULE of an employee;");
        System.out.println("Insert 10 to CREATE NEW PAYMENT SCHEDULES;");
        System.out.println("Insert 11 to LIST EMPLOYEE(S) INFO;");
        System.out.println("Insert 12 to change password of system;");
        System.out.println("Insert -1 to end;");
        System.out.print("Option:  ");

    }
    private static void screenSystemFinished(){
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||System completely finished!|||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }
    private static void clearScreen(){
        for(int i=0;i<50;i++){
            System.out.println("");
        }
    }

    private static int getIndex(String id){
        for(int i=0; i< maxSize; i++){
            if(employees.get(i).getId().equals(id));{
                return i;
            }
        }
        return -1;
    }

    private static String getId(int index){
        if(employees.get(index).getName().length() < 3){
            return patternId + "#" + employees.get(index).getName();
        }
        else
            return patternId + "#" + employees.get(index).getName().substring(0,3);
        //TODO /*mudar para .random() + pattern dps*/
    }
}
