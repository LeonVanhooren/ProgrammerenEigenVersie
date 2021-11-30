import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;

public class BesparingsApp implements ActionListener {
    private ArrayList<Student> students;
    private ArrayList<Landlord> landlords;
    private ArrayList<Building> buildings;
    private ArrayList<Owns> ownerships;
    private ArrayList<Contract> contracts;

    public BesparingsApp(){
        this.students = new ArrayList<>();
        this.landlords = new ArrayList<>();
        this.buildings = new ArrayList<>();
        this.ownerships = new ArrayList<>();
        this.contracts = new ArrayList<>();

    }

    public void addOwnership(Building building, Landlord landlord){
        Owns newOwnership = new Owns(building, landlord);
        if(ownerships.contains(newOwnership)){System.exit(0);}
        else{ownerships.add(newOwnership);}
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
        Scanner keyboard = new Scanner(System.in);
        int answer = 0;


        System.out.println("Welcome "+firstName+" "+lastName+", where are you interested in?");
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

    }


    public void landlordsActiePopUp(String firstName, String lastName, String email, String telephoneNR){
        Scanner keyboard = new Scanner(System.in);
        int answer = 0;

        System.out.println("Welcome "+firstName+" "+lastName+", where are you interested in?");
        System.out.println("1) Adjusting student/contact person list?"+"\n"+
                            "2) Registering energy consumption?"+"\n"+
                            "3) Energy consumption/conservation report?");
        answer = keyboard.nextInt();
        switch(answer){
            case 1:
                adjustingPersonListPopUp();
                break;
            case 2:
                registeringConsumptionPopUp();
                break;
            case 3:
                reportPopUp();

        }
    }

    public void adjustingPersonListPopUp(){

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

        System.out.println("Are you a student or a landlord?");
        answer = keyboard.next();

        if(answer.equals("student")){
            System.out.println("Please type your first name, name and email.");
            voornaam = keyboard.next();
            naam = keyboard.next();
            email = keyboard.next();
            System.out.println("Please type your student number.");
            ID = keyboard.nextInt();
            Student newStudent = new Student(voornaam, naam, email);
            newStudent.setStudentID(ID);
            System.out.println(this.students);
            if(students.contains(newStudent)){
                System.out.println("The database contains your ID!");
                studentsActiePopUP(voornaam, naam, email);
            }

            else{
                System.out.println("U are not yet in the system, would you like to add yourself?");
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
            System.out.println("Please type your first name, name, email and telephone number.");
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
                System.out.println("U are not yet in the system, would you like to add yourself?");
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
