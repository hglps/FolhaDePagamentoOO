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
                        read.nextLine();
                        break;
                    }
                    else if(choice == 1){
                        addEmployee();
                    }
                    else if(choice == 2){
                        deleteEmployee();
                    }
                    else if(choice == 3){
                        setTimeCheck();
                    }
                    else if(choice == 4){
                        resultSales();
                    }
                    
                    else if(choice == 6){
                        changeRegister();
                    }
                    else if(choice == 7) {
                    	payroll();
                    }
                    else if(choice == 11){
                        showInfo();
                    }
                    else System.out.println("Invalid option!\nPlease, insert a valid option:\n");

                    visualizeOptions();
                }

            }
            else if(reading.equalsIgnoreCase("quit")){
                screenSystemFinished();
                break;
            }
            else if(!reading.equalsIgnoreCase("quit"))
                System.out.println("\nInvalid Input! Try again!\n");
        }


    }

    private static void setTimeCheck() {
        String id;
        int index;
        while(true) {
            read.nextLine();
            System.out.println("Insert ID: (insert 'quit' to go back to main menu)");
            id = read.nextLine();
            index = getIndex(id);
            if(id.equalsIgnoreCase("quit")) {
                System.out.println("Back to main screen!");
                break;
            }
            else if(index == -1)
                System.out.println("Employee with ID : " + id + " not found! Press enter to insert again!");
            else {
                Employee currEmployee = employees.get(index);
                System.out.println("Do you want to check-in or check-out?" +
                        "\nInsert 1 to check-in" +
                        "\nInsert 2 to check-out");
                int choice = read.nextInt();
                if (choice == 1) {
                    int hourIn = -1, minuteIn = -1;
                    while (hourIn < 0 || hourIn > 23) {
                        System.out.println("Insert hour of entrance: (Number format : 0 to 23)");
                        hourIn = read.nextInt();
                        if (hourIn < 0 || hourIn > 23) System.out.println("\nInvalid input! Insert again!\n");
                        else {
                            System.out.println("Hour of entry registered successfully!"); break;
                        }
                    }

                    while (minuteIn < 0 || minuteIn > 59) {
                        System.out.println("Insert minute of entrance: (Number format: 0 to 59");
                        minuteIn = read.nextInt();
                        if (minuteIn < 0 || minuteIn > 59) System.out.println("\nInvalid input! Insert again!\n");
                        else {
                            System.out.println("Minute of entry registered successfully!"); break;
                        }
                    }

                    currEmployee.setHourIn(hourIn);
                    currEmployee.setMinuteIn(minuteIn);
                    System.out.println(currEmployee.getHourIn() +":"+ currEmployee.getMinuteIn() +" entry registered successfully to employee "+ currEmployee.getName());

                }
                else if (choice == 2) {
                    //TODO exit
                    int hourOut = -1, minuteOut = -1;
                    while (hourOut < 0 || hourOut > 23) {
                        System.out.println("Insert hour of exit: (Number format : 0 to 23)");
                        hourOut = read.nextInt();
                        if (hourOut < 0 || hourOut > 23) System.out.println("\nInvalid input! Insert again!\n");
                        else {
                            System.out.println("Hour of exit registered successfully!"); break;
                        }
                    }

                    while (minuteOut < 0 || minuteOut > 59) {
                        System.out.println("Insert minute of exit: (Number format: 0 to 59");
                        minuteOut = read.nextInt();
                        if (minuteOut < 0 || minuteOut > 59) System.out.println("\nInvalid input! Insert again!\n");
                        else {
                            System.out.println("Minute of exit registered successfully!"); break;
                        }
                    }

                    currEmployee.setHourOut(hourOut);
                    currEmployee.setMinuteOut(minuteOut); // calculateHours( ) is called here!
                    System.out.println(currEmployee.getHourOut() +":"+ currEmployee.getMinuteOut() +" exit registered successfully to employee "+ currEmployee.getName());
                }
                else
                    System.out.println("Invalid input!Insert again!");
            }

        }
    }

    private static void resultSales(){
        String id;
        int index;
        double value;
        while(true){
            read.nextLine();
            System.out.println("Insert ID: (insert quit to go back to main screen)");
            id = read.nextLine();
            index = getIndex(id);
            if(id.equalsIgnoreCase("quit")){
                System.out.println("Back to main screen!");
                break;
            }
            else if(index == -1)
                System.out.println("Employee with ID: " +  id + " not found! Press enter to try again!");
            else{
                Employee currEmployee = employees.get(index);
                if(currEmployee instanceof Commissioned){
                    System.out.print("Insert value of sale: (Number format : 9999,99)\nR$ ");
                    value = read.nextDouble();////////////TODO aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                    double commissionRate = ((Commissioned) currEmployee).getCommissionRate();
                    ((Commissioned) currEmployee).setCommission(value*commissionRate);
                    System.out.println("Sale registered successfully to employee" + currEmployee.getName());
                }
            }

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
        else
            employees.get(index).leaveUnion();
    }
    private static void setUnionCondition( double unionFee, boolean unionMember, Employee employee){ // used in change of type of payment case
        if(unionMember)
            employee.enterUnion(unionFee, employee.getName(), patternId);
     }

    private static void addEmployee() { //////////////// fix cloned code
        read.nextLine();
        String name, address, typePayment, wayPayment, partOfUnion;
        boolean unionMember;
        double baseSalary=-1 , hourlyRate=-1, unionFee = -1, commissionRate = -1f;

        System.out.println("/////////////////////////////////////////////////////////////////");
        System.out.print("Insert your name (text entry): "); name = read.nextLine();
        System.out.print("Insert your address (text entry): "); address = read.nextLine();
        System.out.print("Insert the type of payment:\n" +
                "Entry format:\nh - hourly / s - salaried / c - commissioned\nType of payment: ");
        typePayment = read.nextLine();
        if(typePayment.equals("s") || typePayment.equals("c")){
            System.out.print("Insert base salary:\nNumber format: 9999,99\nR$ ");
            baseSalary = read.nextDouble();
            if(typePayment.equals("c")){
                while(commissionRate < 0.01 || commissionRate > 0.99){ ////////TODO solve
                    System.out.print("Insert commission rate:\nNumber format: 0,01 to 0,99\nR$ ");
                    commissionRate = read.nextDouble();
                    if(commissionRate < 0.01 || commissionRate > 0.99) System.out.println("Invalid input! Insert again!");
                }
            }
            read.nextLine();
        }
        else if(typePayment.equals("h")){
            System.out.print("Insert the hourly rate for this employee:\nNumber format: 9999,99\nR$");
            hourlyRate = read.nextDouble();
            read.nextLine();
        }
        System.out.println("Insert how you want to get paid:\n" +
                "Entry format:\n'check via mail' - check via mail  /  'check in hands' - check via hands  /  'deposit' - pay via deposit");
        wayPayment = read.nextLine();
        System.out.println("Are you part of any union?\n" +
                "Entry format:\n 'yes' or 'no'\nAnswer:");
        partOfUnion = read.nextLine();
        unionMember = partOfUnion.equals("yes");
        if(unionMember){
            System.out.print("Then, insert the union fee:\nNumber format: 9999,99\n R$ ");
            unionFee = read.nextDouble();
        }

        Employee newEmployee = null;
        int index;
        String id;
        //////////refatorar para economizar linha esses 3 IF's

        if(typePayment.equalsIgnoreCase("h"))
            newEmployee = new Hourly(name,address,typePayment.toLowerCase(), wayPayment, hourlyRate );

        else if(typePayment.equalsIgnoreCase("s"))
            newEmployee = new Salaried(name, address, typePayment.toLowerCase(), wayPayment, baseSalary);

        else if(typePayment.equalsIgnoreCase("c"))
            newEmployee = new Commissioned(name,address, typePayment.toLowerCase(), wayPayment, baseSalary, commissionRate);

        employees.add(newEmployee);
        index = employees.indexOf(newEmployee);
        id = getId(index);
        employees.get(index).setId(id);
        clearScreen();
        setUnionCondition(unionFee,unionMember, index);

        screenWelcomeNewEmployee(index);
    }
    private static void screenWelcomeNewEmployee(int index) {
        if( employees.get(index) instanceof Hourly)
            System.out.println("Welcome hourly employee " + employees.get(index).getName() + "!\nID: " + employees.get(index).getId());
        else if(employees.get(index) instanceof Commissioned)
            System.out.println("Welcome commissioned employee " + employees.get(index).getName() + "!\nID: " + employees.get(index).getId());
        else if(employees.get(index) instanceof  Salaried)
            System.out.println("Welcome salaried employee " + employees.get(index).getName() + "!\nID: " + employees.get(index).getId());

    }

    private static void deleteEmployee() {
        read.nextLine();
        System.out.println("Insert ID: (text entry :: Format - '190021xx@abc' )");
        String id = read.nextLine();
        int index = getIndex(id);
        if(index != -1){
            String name = employees.get(index).getName();
            employees.remove(index);
            System.out.println("Employee " + name + "removed :)");
        }
        else
            System.out.println("Employee with ID : "+ id +" not found!");
    }

    private static void changeRegister(){
        read.nextLine();
        System.out.println("Enter ID:");
        String id = read.nextLine();
        int index = getIndex(id);
        if(index != -1){
            int option;
            /* TODO create method in Employee.java */
            while(true){

                screenChangeRegister();
                option = read.nextInt();
                read.nextLine();
                if(option == 0)
                    break;
                else if(option == 1){
                    screenPrintChangeRegister(1);
                    String name = read.nextLine();
                    employees.get(index).setName(name);
                    System.out.println("Name changed successfully to :" + employees.get(index).getName());
                }
                else if(option == 2){
                    screenPrintChangeRegister(2);
                    String address = read.nextLine();
                    employees.get(index).setAddress(address);
                    System.out.println("Address changed successfully to : " + employees.get(index).getAddress());
                }
                else if(option == 3){
                    Employee changedEmployee = null;
                    Employee currEmployee = employees.get(index);
                    double hourlyRate, baseSalary, commissionRate;
                    System.out.println("\nInsert new type of payment:\n" +
                            "h - hourly / s - salaried / c - commissioned"); String newType = read.nextLine();
                    if(!newType.equals( currEmployee.getTypePayment() )){
                        if( newType.equals("h")){
                            System.out.print("Insert new hourly rate: (Number format: 9999,99)\nR$ ");
                            hourlyRate = read.nextDouble();
                            changedEmployee = new Hourly(currEmployee.getName(), currEmployee.getAddress(), "h", currEmployee.getWayPayment(), hourlyRate);
                        }
                        else if(newType.equals("s") || newType.equals("c")){
                            System.out.print("Insert new base salary: (Number format: 9999,99)\nR$ ");
                            baseSalary = read.nextDouble();
                            if(newType.equals("s"))
                                changedEmployee = new Salaried(currEmployee.getName(), currEmployee.getAddress(), "s", currEmployee.getWayPayment(), baseSalary);
                            else {
                                System.out.print("Insert commission rate: (Number format: 0,01 to 0,99)\nR$ ");
                                commissionRate = read.nextDouble();
                                changedEmployee = new Commissioned(currEmployee.getName(), currEmployee.getAddress(), "c", currEmployee.getWayPayment(), baseSalary, commissionRate);
                            }
                        }
                        changedEmployee.setId(currEmployee.getId());
                        setUnionCondition(currEmployee.getUnion().getUnionFee(), currEmployee.getPartUnion(), changedEmployee);
                        //TODO colocar o set de paidUnionFee e serviceFee :p
                        employees.set(index,changedEmployee);
                    }
                    else
                        System.out.println("Same type of current type of payment! Change not done!");
                }
                else if(option == 4){
                    screenPrintChangeRegister(4);
                    String wayPayment = read.nextLine();
                    employees.get(index).setWayPayment(wayPayment);
                    System.out.println("Way of payment changed successfully to : " + employees.get(index).getWayPayment());
                }
                else if(option == 5){
                    screenPrintChangeRegister(5);
                    String unionPart = read.nextLine();
                    boolean partUnion = unionPart.equals("yes");
                    if(partUnion != employees.get(index).getPartUnion()){
                        if(partUnion){
                            System.out.print("Then, insert the union fee:\nNumber format: 9999,99\n R$ ");
                            double unionFee = read.nextDouble();
                            setUnionCondition(unionFee, true, index);
                            System.out.println(employees.get(index).getName() + "is a union member now!");
                        }
                        else{
                            setUnionCondition(0,false,index);
                            System.out.println(employees.get(index).getName() + "is not a union member anymore!");
                        }
                    }
                    else
                        System.out.println("Same status of current union status! Changes not made!");
                }
                else if(option == 6){
                    if(employees.get(index).getPartUnion()){
                        screenPrintChangeRegister(6);
                        double unionFee = read.nextDouble();
                        employees.get(index).getUnion().setUnionFee(unionFee);
                        System.out.println("Union fee changed successfully to : " + employees.get(index).getUnion().getUnionFee());
                    }
                    else
                        System.out.println("Not part of union! Changes not made!");
                }


            }// end of while true
        }
        else
            System.out.println("Employee with ID : "+ id +" not found!");


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
    private static void screenPrintChangeRegister(int choice){
        if(choice == 1)
            System.out.println("\nInsert new name (text entry):");
        else if(choice == 2)
            System.out.println("\nInsert new address (text entry):");
        else if(choice == 4){
            System.out.println("\nInsert new method of payment:\n" +
                    "Entry format:\n'mail' - check via mail  /  'hands' - check via hands  /  'deposit' - pay via deposit");
        }
        else if(choice == 5){
            System.out.println("\nAre you part of any union?\n" +
                    "Entry format: 'yes'  or  'no'");
        }
        else if(choice == 6)
            System.out.print("\nInsert new union fee:\nNumber format: 9999,99\nUnion fee: ");
    }

    private static void showInfo(){
        System.out.println("Show info of 1 employee or all employees?\n 1 - 1 employee\n 2 - All employees");
        int index, choice = read.nextInt();

        if(choice == 1){
            read.nextLine();
            System.out.println("Insert ID: ");
            String id = read.nextLine();
            index = getIndex(id);
            if(index != -1)
                System.out.println(employees.get(index));
            else
                System.out.println("Employee with ID : "+ id +" not found!");
        }
        else if(choice == 2){
            for(int i=0;i < employees.size(); i++){
                    System.out.println(employees.get(i));
            }
        }
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
        for(int i=0; i < employees.size() ; i++){
            if (employees.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    private static String getId(int index){
        if(employees.get(index).getName().length() < 3){
            return (patternId + index) + "@" + employees.get(index).getName();
        }
        else
            return (patternId + index) + "@" + employees.get(index).getName().substring(0,3);
    }
}
