import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;

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

    public void studentsActiePopUP(String firstName, String lastName, String email){


        FlowPane root = new FlowPane();
        root.setVgap(5);
        root.setHgap(5);
        root.setPadding(new Insets(10,10,10,10));

        root.getChildren().add(new Label("Welcome "+firstName+" "+lastName+", where are you interested in?"),0,0);
        root.add(new Label("1) Adding, changing or deleting of appliances?"),0,1);
        root.add(new Label("2) Energy dconservation menu?"),0,2);
        root.add(new Label("3) Energy consumption/conservation report?"),0,3);

        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");

        Scene scene = new Scene(root, 100, 50);



        /*Scanner keyboard = new Scanner(System.in);
        int answer = 0;


        System.out.println("\n"+"\n"+"\n"+"Welcome "+firstName+" "+lastName+", where are you interested in?");
        System.out.println("1) Adding, changing or deleting of appliances?"+"\n"+
                           "2) Energy conservation menu?"+"\n"+
                           "3) Energy consumption/conservation report?");

        answer = keyboard.nextInt();
        switch (answer){
            case 1:
                appliancesPopUp();
            case 2:
                conservationMenuPopUp();
            case 3:
                reportPopUp();
        }
*/
    }


    public void landlordsActiePopUp(String firstName, String lastName, String email, String telephoneNR){
        Scanner keyboard = new Scanner(System.in);
        String answer;

        answer = JOptionPane.showInputDialog("\n"+"\n"+"\n"+"Welcome "+firstName+" "+lastName+", where are you interested in?"+"\n"
                 +"1) Adjusting student/contact person list?"+"\n"+
                "2) Registering energy consumption?"+"\n"+
                "3) Energy consumption/conservation report?");
        switch(answer){
            case "1":
                adjustingPersonListPopUp();
                break;
            case "2":
                registeringConsumptionPopUp();
                break;
            case "3":
                reportPopUp();
                break;
        }
    }

    public void adjustingPersonListPopUp(){
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

    public void registeringConsumptionPopUp(){

    }

    public void appliancesPopUp(){
        System.out.println();
    }

    public void conservationMenuPopUp(){

    }

    public void reportPopUp(){

    }



    public void studentOrLandlordCheck(){


        Scanner keyboard = new Scanner(System.in);
        String answer = null, naam, voornaam, email, telefoonNR;
        int invoer = 0, ID;

        answer = JOptionPane.showInputDialog("Are you a student or a landlord?");

        if(answer.equals("student")){
            voornaam = JOptionPane.showInputDialog("\n"+"Please type your firstname.");
            naam = JOptionPane.showInputDialog("\n"+"Please type your lastname.");
            email = JOptionPane.showInputDialog("\n"+"Please type your email.");
            ID = Integer.parseInt(JOptionPane.showInputDialog("\n"+"Please type your studentID."));
            Student newStudent = new Student(voornaam, naam, email);
            newStudent.setStudentID(ID);

            if(students.contains(newStudent)){
                JOptionPane.showInputDialog(null, "The database contains your ID!");
                int answer1 = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Click yes or no", JOptionPane.YES_NO_OPTION);

                if(answer1 == JOptionPane.YES_OPTION){
                    studentsActiePopUP(voornaam, naam, email);
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
                System.out.println("\n"+"U are not yet in the system, would you like to add yourself?");
                String antwoord1 = keyboard.next();
                if(antwoord1.equals("yes")||antwoord1.equals("Yes")||antwoord1.equals("YES")){
                    addStudentInput();
                }
                else {
                    System.exit(0);
                }
            }
        }

        else if(answer.equals("Landlord")||answer.equals("landlord")){
            System.out.println("\n"+"Please type your first name, name, email and telephone number.");
            voornaam = keyboard.next();
            naam = keyboard.next();
            email = keyboard.next();
            telefoonNR = keyboard.next();
            System.out.println("Please type your landlordID number.");
            ID = keyboard.nextInt();
            Landlord newLandlord = new Landlord(voornaam, naam, email, telefoonNR);
            newLandlord.setLandlordID(ID);
            System.out.println(this.landlords);
            if(landlords.contains(newLandlord)){
                System.out.println("The database contains your ID!");
                landlordsActiePopUp(voornaam, naam, email, telefoonNR);
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
