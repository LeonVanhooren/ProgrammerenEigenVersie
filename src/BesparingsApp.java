

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Scanner;


public class BesparingsApp {
    private ArrayList<Student> students;
    private ArrayList<Landlord> landlords;
    private ArrayList<Building> buildings;
    private ArrayList<Owns> ownerships;
    private ArrayList<Contract> contracts;
    private ArrayList<Room> rooms;
    private ArrayList<Lease> leases;

    public BesparingsApp(){
        this.students = new ArrayList<>();
        this.landlords = new ArrayList<>();
        this.buildings = new ArrayList<>();
        this.ownerships = new ArrayList<>();
        this.contracts = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.leases = new ArrayList<>();


    }

    public void addOwnership(Building building, Landlord landlord){
        Owns newOwnership = new Owns(building, landlord);
        if(ownerships.contains(newOwnership)){System.exit(0);}
        else{ownerships.add(newOwnership);}
    }

    public void addRoom(Student student, Building building, int roomNR){
        Room newRoom = new Room(student, building, roomNR);
        rooms.add(newRoom);
    }

    public void addLease(Student tenant, Landlord owner){
        Contract newContract = new Contract(tenant, owner);
        if(contracts.contains(newContract)){System.exit(0);}
        else{contracts.add(newContract);}
    }

    public boolean addStudent(String firstName, String lastName, String email){
        Student newStudent = new Student(firstName, lastName, email);
        students.add(newStudent);
        return true;
    }

    public boolean addLandlord(String firstName, String lastName, String email, String telephoneNR){
        Landlord newLandlord = new Landlord(firstName, lastName, email, telephoneNR);
        landlords.add(newLandlord);
        return true;
    }

    public void addBuilding(String street, String number, String zip, String city, String country){
        Building newBuilding = new Building(street, number, zip, city, country);
        if(buildings.contains(newBuilding)){System.exit(0);}
        else{buildings.add(newBuilding);}
    }

    public void addStudentInput(){
        Scanner keyboard = new Scanner(System.in);
        String firstName, lastName, email;

        System.out.println("Please type the firstname of the student.");
        firstName = keyboard.next();
        System.out.println("Please type the name of the student.");
        lastName = keyboard.next();
        System.out.println("Please type the email of the student.");
        email = keyboard.next();

        if(addStudent(firstName, lastName, email)==true){System.out.println("The student is added to the database!");}
        else{System.out.println("Our database already contains this student!");}



    }

    public boolean checkStudent(Student newStudent){
        if(students.contains(newStudent)){return true;}
        else {return false;}
    }

    public void addLandlordInput(){
        Scanner keyboard = new Scanner(System.in);
        String firstName, lastName, email, telephoneNR;

        System.out.println("Please type the firstname of the landlord.");
        firstName = keyboard.next();
        System.out.println("Please type the name of the landlord.");
        lastName = keyboard.next();
        System.out.println("Please type the email of the landlord.");
        email = keyboard.next();
        System.out.println("Please type the telephone number of the landlord.");
        telephoneNR = keyboard.next();

        if(addLandlord(firstName, lastName, email, telephoneNR)==true){System.out.println("De kotbaas is toegevoegd!");}
        else{System.out.println("Deze kotbaas staat al in onze database!");}
    }

    public void studentsActiePopUP(Student student){


        Scanner keyboard = new Scanner(System.in);
        String answer;

        answer = JOptionPane.showInputDialog("\n"+"\n"+"\n"+"Welcome "+student.getFirstName()+" "+student.getLastName()+", where are you interested in?"+"\n"+
        "1) Adding, changing or deleting of appliances?"+"\n"+
                "2) Energy conservation menu?"+"\n"+
                "3) Energy consumption/conservation report?");


        switch (answer){
            case "1":
                appliancesPopUp(student);
            case "2":
                conservationMenuPopUp(student);
            case "3":
                reportPopUpStudent(student);
        }

    }


    public void landlordsActiePopUp(Landlord landlord){
        Scanner keyboard = new Scanner(System.in);
        String answer;

        answer = JOptionPane.showInputDialog("\n"+"\n"+"\n"+"Welcome "+landlord.getName()+", where are you interested in?"+"\n"
                 +"1) Adjusting student/contact person list?"+"\n"+
                "2) Registering energy consumption?"+"\n"+
                "3) Energy consumption/conservation report?");
        switch(answer){
            case "1":
                adjustingPersonListPopUp(landlord);
                break;
            case "2":
                registeringConsumptionPopUp(landlord);
                break;
            case "3":
                reportPopUpLandlord(landlord);
                break;
        }
    }

    public void adjustingPersonListPopUp(Landlord landlord){
        Scanner keyboard = new Scanner(System.in);
        int answer = 0;

        System.out.println("\n"+"Which option are you interested in?"+"\n"+
                "1) Adding a new student to a room --> new contract!"+"\n"+
                "2) Removing a student from a room --> break contract!"+"\n"+
                "3) Changing a student's details --> changing contract!");

        answer = keyboard.nextInt();
        switch(answer){
            case 1:
                System.out.println("Is the student already known in the system?");
                if(keyboard.next().equals("yes")||keyboard.next().equals("Yes")){
                    System.out.println("Type the firstname, name, email and student number of the student you would like to add to a room.");
                    Student newStudent = new Student(keyboard.next(), keyboard.next(), keyboard.next());
                    int studentNR = keyboard.nextInt();
                    newStudent.setStudentID(studentNR);
                    System.out.println("Which room (room number), in which building (buildingID)?");
                    int roomNR = keyboard.nextInt();
                    int buildingID = keyboard.nextInt();
                    System.out.println("Pleas type your landlordID for confirmation.");
                    int landlordID = keyboard.nextInt();

                }
                else{

                }
                break;
            case 2:

                break;
            case 3:

                break;
        }


    }

    public void registeringConsumptionPopUp(Landlord landlord){

    }

    public void appliancesPopUp(Student student){
        System.out.println();
    }

    public void conservationMenuPopUp(Student student){

    }

    public void reportPopUpLandlord(Landlord landlord){


    }

    public void reportPopUpStudent(Student student){


    }



    public void studentOrLandlordCheck(){


        Scanner keyboard = new Scanner(System.in);
        String answer = null;
        int invoer = 0, ID=0;

        final JPanel scene = new JPanel();
        final JLabel titel = new JLabel("Are you a student or a landlord?");
        final JRadioButton student = new JRadioButton("Student");
        final JRadioButton landlord = new JRadioButton("landlord");

        scene.add(titel);
        scene.add(student);
        scene.add(landlord);
        JOptionPane.showMessageDialog(null, scene);

        if(student.isSelected()){

            JTextField firstName = new JTextField();
            JTextField email = new JTextField();
            JTextField studentID = new JTextField();
            JTextField lastName = new JTextField();
            Object[] message = {
                    "First name:", firstName,
                    "Last name:", lastName,
                    "Email:", email,
                    "StudentID:", studentID

            };

            int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

            Student newStudent = new Student(firstName.getText(), lastName.getText(), email.getText());
            newStudent.setStudentID(Integer.parseInt(studentID.getText()));

            if(students.contains(newStudent)){
                JOptionPane.showMessageDialog(null, "The database contains your ID!");
                int answer1 = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Click yes or no", JOptionPane.YES_NO_OPTION);

                if(answer1 == JOptionPane.YES_OPTION){
                    studentsActiePopUP(newStudent);
                }

                else if(answer1 == JOptionPane.NO_OPTION){
                    studentOrLandlordCheck();
                }

                else{
                    JOptionPane.showInputDialog(null, "This is impossible!");
                    System.exit(0);
                }
            }

            else{
                int answer2 =JOptionPane.showConfirmDialog(null,"\n"+"U are not yet in the system, would you like to add yourself?", "Click yes or no", JOptionPane.YES_NO_OPTION);
                if(answer2 == JOptionPane.YES_OPTION){
                    addStudentInput();
                }
                else {
                    studentOrLandlordCheck();
                }
            }
        }

        else if(landlord.isSelected()){

            JTextField firstName = new JTextField();
            JTextField email = new JTextField();
            JTextField landlordID = new JTextField();
            JTextField lastName = new JTextField();
            JTextField telefoonNR = new JTextField();
            Object[] message = {
                    "First name:", firstName,
                    "Last name:", lastName,
                    "Email:", email,
                    "Telephone number", telefoonNR,
                    "LandlordID:", landlordID

            };

            int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);


            Landlord newLandlord = new Landlord(firstName.getText(), lastName.getText(), email.getText(), telefoonNR.getText());
            newLandlord.setLandlordID(Integer.parseInt(landlordID.getText()));
            System.out.println(this.landlords);

            if(landlords.contains(newLandlord)){
                System.out.println("The database contains your ID!");
                landlordsActiePopUp(newLandlord);
            }

            else{
                System.out.println("\n"+"U are not yet in the system, would you like to add yourself?");
                String antwoord1 = keyboard.next();
                if(antwoord1.equals("yes")||antwoord1.equals("Yes")||antwoord1.equals("YES")){
                    addLandlordInput();
                }
                else {
                    System.exit(0);
                }
            }
        }

        else{
            System.exit(0);
        }

    }




    public static void main(String[] args){

        BesparingsApp app = new BesparingsApp();
        app.addStudent("Leon", "Vanhooren", "leon.vanhooren@ugent.be");
        app.addStudent("Milan", "Vissers", "milan.vissers@ugent.be");
        app.addStudent("Hanne", "Willemkens", "hanne.willemkens@ugent.be");
        app.addLandlord("Leon", "Vanhooren", "leon.vanhooren@outlook.be", "0487285571");

        app.studentOrLandlordCheck();


       /*
        Landlord landlord1 = new Landlord("Leon", "Vanhooren", "leon.vanhooren@ugent.be", "048728557");
        Building building = new Building("Timmermansstraat", "21", "8340", "Sijsele", "België");
        Building building1 = new Building("Ter Platen", "33", "9000", "Gent", "België");*/

        System.out.println(app.ownerships);
        System.out.println(app.landlords);
        System.out.println(app.buildings);
        System.out.println(app.students);
        System.out.println(app.contracts);

    }

}
