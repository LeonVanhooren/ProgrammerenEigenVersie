import java.util.ArrayList;
import java.util.Scanner;

public class BesparingsApp {
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
        if(students.contains(newStudent)){
            return false;
        }
        else{
            students.add(newStudent);
            return true;
        }
    }

    public boolean addLandlord(String firstName, String lastName, String email, String telephoneNR){
        Landlord newLandlord = new Landlord(firstName, lastName, email, telephoneNR);
        if(landlords.contains(newLandlord)){return false;}
        else{landlords.add(newLandlord);
        return true;}
    }

    public void addBuilding(String street, String number, String zip, String city, String country){
        Building newBuilding = new Building(street, number, zip, city, country);
        if(buildings.contains(newBuilding)){System.exit(0);}
        else{buildings.add(newBuilding);}
    }

    public void addStudentInput(){
        Scanner keyboard = new Scanner(System.in);
        String firstName, lastName, email;

        System.out.println("Geef de voornaam van de student in.");
        firstName = keyboard.next();
        System.out.println("Geef de achternaam van de student in.");
        lastName = keyboard.next();
        System.out.println("Geef het email adress van de student in.");
        email = keyboard.next();

        if(addStudent(firstName, lastName, email)==true){System.out.println("De student is toegevoegd!");}
        else{System.out.println("Deze student staat al in onze database!");}


    }

    public boolean checkStudent(Student newStudent){
        if(students.contains(newStudent)){return true;}
        else {return false;}
    }

    public void addLandlordInput(){
        Scanner keyboard = new Scanner(System.in);
        String firstName, lastName, email, telephoneNR;

        System.out.println("Geef de voornaam van de kotbaas in.");
        firstName = keyboard.next();
        System.out.println("Geef de achternaam van de kotbaas in.");
        lastName = keyboard.next();
        System.out.println("Geef het email adress van de kotbaas in.");
        email = keyboard.next();
        System.out.println("Geef het telelfoonnummer van de kotbaas in.");
        telephoneNR = keyboard.next();

        if(addLandlord(firstName, lastName, email, telephoneNR)==true){System.out.println("De kotbaas is toegevoegd!");}
        else{System.out.println("Deze kotbaas staat al in onze database!");}
    }

    public void studentenActiePopUP(String firstName, String lastName, String email, int studentenNR){
        Scanner keyboard = new Scanner(System.in);
        int answer = 0;
        System.out.println("Welkom "+firstName+" "+lastName+", waar bent u in geïnteresseerd?");
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

    public void appliancesPopUp(){

    }

    public void conservationMenuPopUp(){

    }

    public void reportPopUp(){

    }





    public static void main(String[] args){

        BesparingsApp app = new BesparingsApp();
        app.addStudent("Leon", "Vanhooren", "leon.vanhooren@ugent.be");

        Scanner keyboard = new Scanner(System.in);
        String answer = null, naam, voornaam, email;
        int invoer = 0, ID;

        System.out.println("Bent u een student of een kotbaas?");
        answer = keyboard.next();
        if(answer.equals("student")){
            System.out.println("Geef uw voornaam, naam, email.");
            voornaam = keyboard.next();
            naam = keyboard.next();
            email = keyboard.next();
            System.out.println("Geef uw studentennummer in.");
            ID = keyboard.nextInt();
            Student newStudent = new Student(voornaam, naam, email);
            newStudent.setStudentID(ID);
            if(app.checkStudent(newStudent)==true){
                System.out.println("U bevindt zich in het systeem.");
                app.studentenActiePopUP(voornaam, naam, email, ID);
            }

            else{
               System.out.println("U bevindt zich nog niet in het systeem. Wenst u uwzelf toe te voegen?");
               String antwoord1 = keyboard.next();
               if(antwoord1.equals("ja")||antwoord1.equals("Ja")||antwoord1.equals("JA")){
                   app.addStudentInput();
                   String voornaam1 = app.students.get(app.students.size()).getFirstName();
                   String achternaam1 = app.students.get(app.students.size()).getLastName();
                   String email1 = app.students.get(app.students.size()).getEmail();
                   int ID1 = app.students.get(app.students.size()).getStudentID();
                   app.studentenActiePopUP(voornaam1, achternaam1, email1, ID1-1 );
               }
               else {
                   System.exit(0);
               }
            }
        }
        else{}
        /*
        do {
            System.out.println("Welke actie wilt u uitvoeren?" + "\n" +
                    "--> Toevoegen van een student? Druk op 1!" +"\n"+
                    "--> Toevoegen van een kotbaas? Druk op 2!" +"\n"+
                    "--> Toevoegen van een gebouw? Druk op 3!" +"\n"
            );
            invoer = keyboard.nextInt();

            switch (invoer) {
                case 1:
                    app.addStudentInput();
                    break;
                case 2:
                    app.addLandlordInput();
                    break;
                case 3:
                    break;

            }
            System.out.println("Wilt u nog iets doen?");
            answer = keyboard.next();
        }
        while(answer.equals("Ja")||answer.equals("ja")||answer.equals("JA"));*/
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
