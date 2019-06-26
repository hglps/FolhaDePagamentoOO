package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    public static Scanner read = new Scanner(System.in);
    private final static int patternId = 19002100;
    private final static int maxSize = 500;
    private static ArrayList<Employee> employees = new ArrayList<Employee>(maxSize);
    private static MyCalendar date = new MyCalendar();
    private static String[] schedules = new String[maxSize];
    private static int counterSchedules = 0;

    /*
    * ID = patternID + @ + name.substring(0,3)
    * */
    
    public static void main(String[] args) {
        String password = "admin";
        String reading;
        boolean error;
        //TODO to loko
        while(true){
            error = true;
            screenEnterPassword();
            reading = read.nextLine();
            if(reading.equals(password)){
                //start main code
//                System.out.println("Started main code :)");
                visualizeOptions();
                while(true){
                    error = true;
                    int choice=-1;
                    while(error) {
                        try {
                            choice = read.nextInt();
                            error = false;
                        } catch (Exception e) {
                            System.out.println("INVALID INPUT! Expecting an integer value! Try again!");
                            visualizeOptions();
                            read.nextLine();
                            error = true;
                        }
                    }
                        if (choice == -1) {
                            System.out.println("\n\nPayroll system finished\n");
                            read.nextLine();
                            break;
                        } else if (choice == 1) {
                            addEmployee();
                        } else if (choice == 2) {
                            deleteEmployee();
                        } else if (choice == 3) {
                            setTimeCheck();
                        } else if (choice == 4) {
                            resultSales();
                        } else if (choice == 5) {
                            serviceFee();
                        } else if (choice == 6) {
                            changeRegister();
                        } else if (choice == 7) {
                            read.nextLine();
                            System.out.println("Warning!! Be aware that a day is passed after the payroll execution!");
                            System.out.println("If you want to proceed, enter 'yes' or anything else to go back to main screen");
                            String enter = read.nextLine();
                            if (enter.equalsIgnoreCase("yes"))
                                payroll();
                            else
                                System.out.println("Back to main screen");
                        } else if (choice == 8) {
                            undoRedo();
                        } else if (choice == 9) {
                            setNewPayday();
                        } else if (choice == 10) {
                            createSchedules();
                        } else if (choice == 11) {
                            showInfo();
                        } else if (choice == 12) {
                            read.nextLine();
                            System.out.println("Insert the current password:");
                            String currentPasswordCheck = read.nextLine();
                            if (currentPasswordCheck.equals(password)) {
                                System.out.println("OK, now insert the new password:");
                                password = read.nextLine();
                                System.out.println("The new password is " + password);
                            } else
                                System.out.println("Wrong password!");
                        } else System.out.println("Invalid option!\nPlease, insert a valid option:\n");

                        visualizeOptions();
                }// while hasNext

            }// check password
            else if(reading.equalsIgnoreCase("quit")){
                screenSystemFinished();
                break;
            }
            else if(!reading.equalsIgnoreCase("quit"))
                System.out.println("\nInvalid Input! Try again!\n");
        }


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
        String name, address, typePayment = null, wayPayment, partOfUnion = null;
        boolean unionMember, error = true;
        double baseSalary=-1 , hourlyRate=-1, unionFee = -1, commissionRate = -1f;

        System.out.println("/////////////////////////////////////////////////////////////////");
        System.out.print("Insert your name (text entry): ");
        name = read.nextLine();
        System.out.print("Insert your address (text entry): "); address = read.nextLine();
        while(true) {
            System.out.print("Insert the type of payment:\n" +
                    "Entry format:\nh - hourly / s - salaried / c - commissioned\nType of payment: ");
            typePayment = read.nextLine();
            if(!typePayment.equalsIgnoreCase("h" ) && !typePayment.equalsIgnoreCase("s") && !typePayment.equalsIgnoreCase("c"))
                System.out.println("Invalid input! Only accepting 'h', 's' or 'c'");
            else break;
        }

        if(typePayment.equals("s") || typePayment.equals("c")){
            while(error) {
                System.out.print("Insert base salary:\nNumber format: 9999,99\nR$ ");
                try{
                    baseSalary = read.nextDouble();
                    error = false;
                }
                catch(Exception e){
                    System.out.println("INVALID INPUT! Expected a float value!  Try again!");
                    read.nextLine();
                    error = true;
                }
                if(baseSalary <= 0){
                    System.out.println("Expecting base salary greater than zero! Try again!");
                    error = true;
                }
                else break;
            }
            error = true;
            if(typePayment.equals("c")) {
                while (error && (commissionRate < 0.01 || commissionRate > 0.99)){
                        System.out.print("Insert commission rate:\nNumber format: 0,01 to 0,99\nR$ ");
                        try{
                            commissionRate = read.nextDouble();
                            error = false;
                        }
                        catch(Exception e){
                            System.out.println("Invalid INPUT! Expected float value! Try again!");
                            read.nextLine();
                            error = true;
                        }
                        if (commissionRate < 0.01 || commissionRate > 0.99) {
                            System.out.println("Invalid input! Insert again! (Input: from 0,01 to 0,99)");
                            error = true;
                        }
                        else break;
                }
            }
            read.nextLine();
        }

        else if(typePayment.equals("h")){
            error = true;
            while(error) {
                System.out.print("Insert the hourly rate for this employee:\nNumber format: 9999,99\nR$");
                try {
                    hourlyRate = read.nextDouble();
                    error= false;
                }
                catch(Exception e){
                    System.out.println("Invalid input! Expected a float numeric value! Try again!");
                    read.nextLine();
                    error = true;
                }
                if(hourlyRate <= 0){
                    System.out.println("Expecting hourly rate greater than zero! Try again!");
                    error = true;
                }
                else break;
            }
            read.nextLine();
        }
        while(true) {
            System.out.println("Insert how you want to get paid:\n" +
                    "Entry format:\n'check via mail' - check via mail  /  'check in hands' - check via hands  /  'deposit' - pay via deposit");
            wayPayment = read.nextLine();
            if(!wayPayment.equals("check via mail") && !wayPayment.equals("check in hands") && !wayPayment.equalsIgnoreCase("deposit"))
                System.out.println("Invalid input!");
            else break;
        }
        while(true) {
            System.out.println("Are you part of any union?\n" +
                    "Entry format:\n 'yes' or 'no'\nAnswer:");
            partOfUnion = read.nextLine();
            if(!partOfUnion.equalsIgnoreCase("yes") && !partOfUnion.equalsIgnoreCase("no"))
                System.out.println("Invalid input! Expecting only 'yes' or 'no' input! Try again!");
            else break;
        }
        error = true;
        unionMember = partOfUnion.equals("yes");
        if(unionMember){
            while(error) {
                System.out.print("Then, insert the union fee:\nNumber format: 9999,99\n R$ ");
                try {
                    unionFee = read.nextDouble();
                    error = false;
                } catch (Exception e) {
                    System.out.println("Invalid input! Expecting a float numeric value! Try again");
                    read.nextLine();
                    error = true;
                }
                if (unionFee <= 0){
                    System.out.println("Please, insert a value greater than zero!");
                    error = true;
                }
                else break;
            }

        }

        Employee newEmployee = null;
        int index;
        String id;

        if(typePayment.equalsIgnoreCase("h"))
            newEmployee = new Hourly(name,address,typePayment.toLowerCase(), wayPayment.toLowerCase(), hourlyRate );

        else if(typePayment.equalsIgnoreCase("s"))
            newEmployee = new Salaried(name, address, typePayment.toLowerCase(), wayPayment.toLowerCase(), baseSalary);

        else if(typePayment.equalsIgnoreCase("c"))
            newEmployee = new Commissioned(name,address, typePayment.toLowerCase(), wayPayment.toLowerCase(), baseSalary, commissionRate);

        employees.add(newEmployee);
        index = employees.indexOf(newEmployee);
        id = getId(index);
        employees.get(index).setId(id);
        employees.get(index).startPayday();
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

    private static void setTimeCheck() {
        String id;
        int index;
        boolean error;
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
                int choice = 0;
                error = true;
                while(error) {
                    System.out.println("Do you want to check-in or check-out?" +
                            "\nInsert 1 to check-in" +
                            "\nInsert 2 to check-out");
                    try {
                        choice = read.nextInt();
                        error = false;
                    }
                    catch(Exception e){
                        System.out.println("Invalid input! Expecting integer value! Try again!");
                        read.nextLine();
                        error = true;
                    }
                    if(choice != 1 && choice != 2){
                        System.out.println("Expecting input '1' or '2'! Try again!");
                        error = true;
                    }
                    else break;
                }
                if (choice == 1) {
                    int hourIn = -1, minuteIn = -1;
                    error = true;
                    while ((hourIn < 0 || hourIn > 23) && error ) {
                        System.out.println("Insert hour of entrance: (Number format : 0 to 23)");
                        try {
                            hourIn = read.nextInt();
                            error = false;
                        }
                        catch(Exception e){
                            System.out.println("Invalid input ! Expecting integer value! Try again!");
                            read.nextLine();
                            error = true;
                        }
                        if (hourIn < 0 || hourIn > 23) {
                            System.out.println("\nExpecting hour between 0 and 23! Insert again!\n");
                            error = true;
                        }
                        else break;
                    }
                    error = true;
                    while ((minuteIn < 0 || minuteIn > 59) && error) {
                        System.out.println("Insert minute of entrance: (Number format: 0 to 59");
                        try {
                            minuteIn = read.nextInt();
                            error = false;
                        }
                        catch(Exception e){
                            System.out.println("Expecting integer value! Try again!");
                            read.nextLine();
                            error = true;
                        }
                        if (minuteIn < 0 || minuteIn > 59) {
                            System.out.println("\nInvalid input! Insert again!\n");
                            error = true;
                        }
                        else break;
                    }

                    currEmployee.setHourIn(hourIn);
                    currEmployee.setMinuteIn(minuteIn);
                    System.out.println(currEmployee.getHourIn() +":"+ currEmployee.getMinuteIn() +" entry registered successfully to employee "+ currEmployee.getName());

                }
                else if (choice == 2) {
                    //TODO exit
                    int hourOut = -1, minuteOut = -1;
                    error = true;
                    while ((hourOut < 0 || hourOut > 23) && error) {
                        System.out.println("Insert hour of exit: (Number format : 0 to 23)");
                        try {
                            hourOut = read.nextInt();
                            error = false;
                        }
                        catch(Exception e){
                            System.out.println("Expecting integer value! Try again!");
                            read.nextLine();
                            error = true;
                        }
                        if (hourOut < 0 || hourOut > 23) {
                            System.out.println("\nInvalid input! Insert again!\n");
                            error = true;
                        }
                        else break;
                    }
                    error = true;
                    while ((minuteOut < 0 || minuteOut > 59) && error) {
                        System.out.println("Insert minute of exit: (Number format: 0 to 59");
                        try{
                            minuteOut = read.nextInt();
                            error = false;
                        }
                        catch(Exception e){
                            System.out.println("Expecting integer value!! Try again!");
                            read.nextLine();
                            error = true;
                        }
                        if (minuteOut < 0 || minuteOut > 59) {
                            System.out.println("\nInvalid input! Insert again!\n");
                            error = true;
                        }
                        else break;
                    }

                    currEmployee.setHourOut(hourOut);
                    currEmployee.addHours( currEmployee.setMinuteOut(minuteOut) );
                    currEmployee.addDayWorked();// calculateHours( ) is called here!
                    if(currEmployee instanceof Hourly)
                        ((Hourly)currEmployee).calculateHours();
                    else if(currEmployee instanceof Commissioned)
                        ((Commissioned)currEmployee).calculateHours();
                    else if(currEmployee instanceof Salaried)
                        ((Salaried)currEmployee).calculateHours();
                    System.out.println("hours = "+currEmployee.getHours());
                    System.out.println(currEmployee.getHourOut() +":"+ currEmployee.getMinuteOut() +" exit registered successfully to employee "+ currEmployee.getName());

                    currEmployee.setHourIn(0); currEmployee.setHourOut(0); currEmployee.setMinuteIn(0); currEmployee.setMinuteOut(0);
                }
                else
                    System.out.println("Invalid input!Insert again!");
            }

        }
    }

    private static void resultSales(){
        String id;
        int index;
        boolean error ;
        double value, commissionRate;
        while(true){
            value = -1;
            error = true;
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
                    while (value < 0 && error) {
                        System.out.print("Insert value of sale: (Number format : 9999,99)\nR$ ");
                        try {
                            value = read.nextDouble();
                            error = false;
                        }
                        catch(Exception e){
                            System.out.println("Invalid Input! Insert valid numeric input! Try again!");
                            read.nextLine();
                            error = true;
                        }
                        if (value > 0) {
                            error = false;
                            break;
                        }
                        else if(value <= 0) {
                            error = true;
                            System.out.println("Invalid double input! Enter values greater than zero!");
                        }
                    }
                    commissionRate = ((Commissioned) currEmployee).getCommissionRate();
                    ((Commissioned) currEmployee).addCommission(value * commissionRate);
                    System.out.println("Sale registered successfully to employee" + currEmployee.getName());
                }
            }
        }
    }

    private static void serviceFee() {
        read.nextLine();
        String id;
        int index;
        boolean error= true;
        while(true){
            System.out.println("--ServiceFee--\nInsert ID: (insert 'quit' to go back to main screen)");
            id = read.nextLine();
            index = getIndex(id);
            if(id.equalsIgnoreCase("quit")) {
                System.out.println("Back to main menu!");
                break;
            }
            else if(index == -1)
                System.out.println("The employee with ID : " + id + " was not found! Try again!");
            else if(index != -1){
                if(employees.get(index).getPartUnion()){
                    double serviceFee = -1;
                    while(error && serviceFee <= 0){
                        System.out.print("Insert service fee: (Number format: 9999,99)\nR$");
                        try{
                            serviceFee = read.nextDouble();
                            error = false;
                        }
                        catch(Exception e){
                            System.out.println("Invalid input! Expected a float numeric value! Try again!");
                            read.nextLine();
                            error = true;
                        }
                        if(serviceFee <=0){
                            System.out.println("Expected a service fee greater than zero! Try again!");
                            error = true;
                        }
                        else break;
                    }
                    employees.get(index).getUnion().addServiceFee(serviceFee);
                    System.out.println("R$ " + serviceFee + " of service fee successfully registered on " + employees.get(index).getName() + "'s union account!");
                    read.nextLine();
                }
                else
                    System.out.println("The selected employee is not part of any union!");
            }
        }


    }

    private static void changeRegister(){
        read.nextLine();
        boolean error = true;
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
                    double hourlyRate=-1, baseSalary=-1, commissionRate = -1;
                    String newType;
                    while(true) {
                        System.out.println("\nInsert new type of payment:\n" +
                                "h - hourly / s - salaried / c - commissioned");
                        newType = read.nextLine();
                        if(!newType.equalsIgnoreCase("h") && !newType.equalsIgnoreCase("s") && !newType.equalsIgnoreCase("c"))
                            System.out.println("Invalid input! Expecting only 'h', 's' or 'c' inputs!");
                        else break;
                    }
                    if(!newType.equals( currEmployee.getTypePayment() )){
                        if( newType.equals("h")){

                            while(error) {
                                System.out.print("Insert new hourly rate: (Number format: 9999,99)\nR$ ");
                                try {
                                    hourlyRate = read.nextDouble();
                                    error = false;
                                }
                                catch(Exception e){
                                    System.out.println("Invalid input! Expecting a float numeric value! Try again");
                                    error = true;
                                }
                                if(hourlyRate <= 0){
                                    System.out.println("Invalid input! Expecting values greater than zero! Try again!");
                                    error = true;
                                }
                                else break;
                            }
                            changedEmployee = new Hourly(currEmployee.getName(), currEmployee.getAddress(), "h", currEmployee.getWayPayment(), hourlyRate);
                        }
                        else if(newType.equals("s") || newType.equals("c")){
                            while(error) {
                                System.out.print("Insert new base salary: (Number format: 9999,99)\nR$ ");
                                try {
                                    baseSalary = read.nextDouble();
                                    error = false;
                                }
                                catch(Exception e){
                                    System.out.println("INVALID INPUT! Expecting a float numeric value! Try again!");
                                    error = true;
                                }
                                if(baseSalary <= 0){
                                    System.out.println("Expecting a base salary greater than zero! Try again!");
                                    error = true;
                                }
                                else break;
                            }
                            if(newType.equals("s"))
                                changedEmployee = new Salaried(currEmployee.getName(), currEmployee.getAddress(), "s", currEmployee.getWayPayment(), baseSalary);
                            else {
                                error = true;
                                while(error) {
                                    System.out.print("Insert commission rate: (Number format: 0,01 to 0,99)\nR$ ");
                                    try {
                                        commissionRate = read.nextDouble();
                                        error = false;
                                    }
                                    catch(Exception e){
                                        System.out.println("INVALID INPUT! Expecting a float numeric value! Try again!");
                                        error = true;
                                    }
                                    if(commissionRate <=0 || commissionRate > 0.99){
                                        System.out.println("Invalid input! Expecting a value greater than zero and less than one! Try again!");
                                        error = true;
                                    }
                                    else break;
                                }
                                changedEmployee = new Commissioned(currEmployee.getName(), currEmployee.getAddress(), "c", currEmployee.getWayPayment().toLowerCase(), baseSalary, commissionRate);
                            }
                        }
                        changedEmployee.setId(currEmployee.getId());
                        changedEmployee.startPayday();
                        setUnionCondition(currEmployee.getUnion().getUnionFee(), currEmployee.getPartUnion(), changedEmployee);
                        //TODO colocar o set de paidUnionFee e serviceFee :p
                        employees.set(index,changedEmployee);
                    }
                    else
                        System.out.println("Same type of current type of payment! Change not done!");
                }
                else if(option == 4){
                    String wayPayment;
                    while(true) {
                        screenPrintChangeRegister(4);
                        wayPayment = read.nextLine();
                        if(!wayPayment.equalsIgnoreCase("check in hands") && !wayPayment.equalsIgnoreCase("check via mail") && ! wayPayment.equalsIgnoreCase("deposit"))
                            System.out.println("Invalid input! Try again!");
                        else break;
                    }
                    employees.get(index).setWayPayment(wayPayment.toLowerCase());
                    System.out.println("Way of payment changed successfully to : " + employees.get(index).getWayPayment());
                }
                else if(option == 5){
                    String unionPart;

                    while(true) {
                        screenPrintChangeRegister(5);
                        unionPart = read.nextLine();
                        if(!unionPart.equalsIgnoreCase("yes") && !unionPart.equalsIgnoreCase("no"))
                            System.out.println("Expecting input as 'yes' or 'no' ! Try again!");
                        else break;
                    }
                    boolean partUnion = unionPart.equalsIgnoreCase("yes");
                    if(partUnion != employees.get(index).getPartUnion()){
                        if(partUnion){
                            error = true;
                            double unionFee= -1;
                            while (error) {
                                System.out.print("Then, insert the union fee:\nNumber format: 9999,99\n R$ ");
                                try {
                                    unionFee = read.nextDouble();
                                    error = false;
                                }
                                catch(Exception e){
                                    System.out.println("Invalid input! Expecting a float numeric value! Try again!");
                                    error = true;
                                }
                                if(unionFee <= 0){
                                    System.out.println("Expecting a union fee greater than zero! Try again!");
                                    error = true;
                                }
                                else break;
                            }
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
                        error = true;
                        double unionFee= -1;
                        while (error) {
                            System.out.print("Then, insert the union fee:\nNumber format: 9999,99\n R$ ");
                            try {
                                unionFee = read.nextDouble();
                                error = false;
                            }
                            catch(Exception e){
                                System.out.println("Invalid input!! Expecting a float numeric value! Try again!");
                                error = true;
                            }
                            if(unionFee <= 0){
                                System.out.println("Expecting a union fee greater than zero! Try again!");
                                error = true;
                            }
                            else break;
                        }
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

    private static void payroll() {

        for(int i =0 ; i < employees.size(); i++){
            if(employees.get(i) instanceof Hourly)
                ((Hourly) employees.get(i)).calculateSalary(date.getDayWeek(), date.getCounterDate(), date.getLastWorkDay());
            else if(employees.get(i) instanceof  Commissioned)
                ((Commissioned) employees.get(i)).calculateSalary(date.getDayWeek(), date.getCounterDate(), date.getLastWorkDay());
            else if(employees.get(i) instanceof  Salaried)
                ((Salaried) employees.get(i)).calculateSalary(date.getDayWeek(), date.getCounterDate(), date.getLastWorkDay());
        }
        date.setNewDate();
    }

    private static void setNewPayday() {
        read.nextLine();
        String id, opt;
        int index, optionSchedule = -1;
        while(true){
            System.out.println("Insert ID: (insert 'quit' to go back to main menu)");
            id = read.nextLine();
            index = getIndex(id);
            if(id.equalsIgnoreCase("quit")){
                System.out.println("Back to main menu!");
                break;
            }
            else if(index == -1){
                System.out.println("The employee with ID: "+ id + " was not found! Try again!");
            }
            else if(index != -1){
                Employee currEmployee = employees.get(index);
                for(int i=0;i< counterSchedules;i++){
                    if(currEmployee instanceof Hourly && schedules[i].substring(0,4).equals("s 01"))
                        System.out.println(i + " - " + schedules[i]);
                    else if(currEmployee instanceof Commissioned && schedules[i].substring(0,4).equals("s 02"))
                        System.out.println(i + " - " + schedules[i]);
                    else if(currEmployee instanceof Salaried && schedules[i].substring(0,1).equals("m"))
                        System.out.println(i + " - " + schedules[i]);
                }
                boolean error = true;
                System.out.println("If you want to change your payment schedule, select one valid shown number\nElse, insert 'over' to go back to main screen");
                opt = read.nextLine();
                if(opt.equals("over"))
                    System.out.println("Back to main screen.\n-----------------------------------------------------------------------");
                else{
                    if(opt.equals(currEmployee.getPayday().substring(0,1))) {
                        while (error) {
                            try {
                                optionSchedule = Integer.parseInt(opt);
                                error = false;
                            } catch (Exception e) {
                                System.out.println("INVALID INPUT! Expected integer number! Try again!");
                                error = true;
                            }
                        }
                        currEmployee.setPayday(schedules[optionSchedule]);
                        System.out.println("New schedule registered to employee " + currEmployee.getName());
                    }
                }
            }


        }


    }

    private static void createSchedules() {
        String schedule = "";
        while (true) {
            String entry;
            System.out.println("Insert 'over' to go back to main screen");
            System.out.println("....Adding new payment schedules....\n");
            while(true) {
                System.out.print("Insert type:\nm - monthly  /  s - weekly\n->");
                entry = read.nextLine();
                if (entry.equalsIgnoreCase("over")) break;
                else if(!entry.equalsIgnoreCase("m") && !entry.equalsIgnoreCase("s"))
                    System.out.println("Invalid input! Expecting only 'm' or 's' input! Try again!");
                else break;
            }
            schedule += entry;

            if (schedule.equals("m")) {
                System.out.println("Insert a number for the day of payment:\nNumber format: '01' - '25' or '00' to last business day");
                entry = read.nextLine();

                if (entry.equalsIgnoreCase("over")) break;
                schedule += " " + entry;
            } else if (schedule.equals("s")) {
                while(true) {
                    System.out.println("Insert number of worked weeks required: 01 or 02");
                    entry = read.nextLine();
                    if (entry.equalsIgnoreCase("over")) break;
                    else if(!entry.equalsIgnoreCase("01") && !entry.equalsIgnoreCase("02"))
                        System.out.println("Invalid input! Expecting only '01' or '02' inputs! Try again!");
                    else break;
                }
                if (entry.equalsIgnoreCase("over")) break;
                schedule += " " + entry;

                System.out.println("Insert the day of week:\n" +
                        "0 - Monday\n1 - Tuesday\n2 - Wednesday\n3 - Thursday\n4 - Friday\n5 - Saturday\n6 - Sunday");

                entry = read.nextLine();
                if (entry.equalsIgnoreCase("over")) break;
                schedule += " " + entry;
            }
            schedules[counterSchedules] = schedule;
            counterSchedules += 1;
        }
    }

    private static void showInfo(){
        System.out.println("Show info of 1 employee or all employees?\n 1 - 1 employee\n 2 - All employees");
        int index, choice = read.nextInt();

        if(choice == 1){
            read.nextLine();
            System.out.println("Insert ID: ");
            String id = read.nextLine();
            index = getIndex(id);
            if(index != -1) {
                System.out.println("----------------------------------------------");
                System.out.println(employees.get(index));
                System.out.println("----------------------------------------------");
            }
            else
                System.out.println("Employee with ID : "+ id +" not found!");
        }
        else if(choice == 2){
            for(int i=0;i < employees.size(); i++){
                System.out.println("----------------------------------------------");
                System.out.println(employees.get(i));//TODO
                System.out.println("----------------------------------------------");
            }
        }
    }

    private static void undoRedo() {
        System.out.println("\nMethod not made in time!");
        System.out.println("It'd be used 2 stacks. One for undo, the other for redo.\nCreating a new object for every employee and, then, adding to the stack, to be saved, properly!");
        System.out.println("Just a concept!");
        System.out.println("Back to main screen! Press enter to go back!\n");
        read.nextLine();
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
    
    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    //    private static void clearScreen(){
//        for(int i=0;i<50;i++){
//            System.out.println("");
//        }
//    }
}
