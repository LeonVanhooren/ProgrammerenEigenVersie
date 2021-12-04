import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;


    public class App implements ActionListener {
        private ArrayList<Student> students;
        private ArrayList<Landlord> landlords;
        private ArrayList<Building> buildings;
        private ArrayList<Owns> ownerships;
        private ArrayList<Contract> contracts;
        private ArrayList<Room> rooms;
        private ArrayList<Lease> leases;
        private ArrayList<StudentPassword> studentPasswords;
        private ArrayList<LandlordPassword> landlordPasswords;

        public App()  {
            this.students = new ArrayList<>();
            this.landlords = new ArrayList<>();
            this.buildings = new ArrayList<>();
            this.ownerships = new ArrayList<>();
            this.contracts = new ArrayList<>();
            this.rooms = new ArrayList<>();
            this.leases = new ArrayList<>();
            this.studentPasswords = new ArrayList<>();
            this.landlordPasswords = new ArrayList<>();


        }

        //We moeten een exception throwen als meerdere vakjes gekozen worden bij de methodes of een manier vinden om te programmeren dat er maar 1 vakje gekozen kan worden!!

    public void menu(){
        JRadioButton student = new JRadioButton("Student");
        JRadioButton landlord = new JRadioButton("Landlord");


        Object[] message = {"         Choose your function",student, landlord};

        int option = JOptionPane.showConfirmDialog(null, message, "Function menu", JOptionPane.CANCEL_OPTION);

        if(student.isSelected()){studentMenu();}
        if(landlord.isSelected()){landlordMenu();}
        if(option == JOptionPane.CANCEL_OPTION){System.exit(0);}
    } //JRadioButton kan meerdere knoppen tergelijk selecteren dus Exception maken met maar 1 optie mogelijk?

    public void studentMenu(){
        JRadioButton register = new JRadioButton("Register");
        JRadioButton login = new JRadioButton("Login");

        Object[] message = {"Do you want to register or to log in?",register, login};

        int option = JOptionPane.showConfirmDialog(null, message, "Student menu", JOptionPane.CANCEL_OPTION);

        if(register.isSelected()){studentRegister();}
        if(login.isSelected()){studentLogin();}
        if(option == JOptionPane.CANCEL_OPTION){menu();}

    } //Ook hier een exception hiervoor

    public void studentRegister(){
        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JTextField email = new JTextField();

        JTextField password = new JPasswordField();
        Object[] message = {
                "First name:", firstName,
                "Last name:", lastName,
                "Email:", email,
                "Password:", password

        };

        int option1 = JOptionPane.showConfirmDialog(null, message, "Student register", JOptionPane.OK_CANCEL_OPTION);
        Student newStudent = new Student(firstName.getText(), lastName.getText(), email.getText(), password.getText());

        if(option1 ==JOptionPane.OK_OPTION){
            if(studentPresent(newStudent)==false){
                JOptionPane.showMessageDialog(null, "You have successfully added your profile!"+"\n"+"Your student number: "+newStudent.getStudentID()+"\n"+"Remember this well!");
                //Methode voor checken van correct email?
                studentOptionsMenu(newStudent);

            }
            else{

                Object[] message2 ={"You are already in the system!", "Do you want to log in instead?"};
                int option2 = JOptionPane.showConfirmDialog(null, message2, "Error", JOptionPane.YES_NO_OPTION);
                if(option2==JOptionPane.YES_OPTION){studentLogin();}
                if(option2==JOptionPane.NO_OPTION){studentRegister();}
            }

        }
        if(option1 == JOptionPane.CANCEL_OPTION){studentMenu();}

    }

    public boolean studentPresent(Student student){
            for(Student newStudent:students){
                if(newStudent.getName().equals(student.getName())&&newStudent.getEmail().equals(student.getEmail())){
                    return true;
                }
            }
            return false;
        } //methode die checkt als de student al in de DB zit

    public void studentLogin(){
        Student errorStudent = new Student("0", "0", "0", "0");

        JTextField email = new JTextField();
        JTextField studentNR = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
                "Email:", email,
                "Student number: ",studentNR,
                "Password:", password

        };

        int option1 = JOptionPane.showConfirmDialog(null, message, "Student login", JOptionPane.OK_CANCEL_OPTION);

        if(option1 ==JOptionPane.OK_OPTION){
            if(!studentDatabaseCheck(email.getText(), password.getText(), Integer.parseInt(studentNR.getText())).equals(errorStudent)){
                JOptionPane.showMessageDialog(null,"You are successfully logged in!");

                studentOptionsMenu(studentDatabaseCheck(email.getText(), password.getText(), Integer.parseInt(studentNR.getText())));
            }
            else{

                Object[] message2 ={"The password and email are not correct!","Please try again!"};
                int option2 = JOptionPane.showConfirmDialog(null, message2, "Error", JOptionPane.OK_CANCEL_OPTION);
                if(option2==JOptionPane.OK_OPTION){studentLogin();}
                if(option2==JOptionPane.CANCEL_OPTION){studentMenu();}
            }

        }
        if(option1 == JOptionPane.CANCEL_OPTION){menu();}


    } //vanaf hier moet elke methode de Student en Kamer object bijhouden zodanig dat die kunnen gebruikt worden om gegevens toe te voegen gekoppeld aan de juiste persoon

    public Student studentDatabaseCheck(String email, String password, int studentNR){
            //database check methode
        StudentPassword newStudent = new StudentPassword(email, password);
        Student errorStudent = new Student("0", "0", "0", "0");
        for(StudentPassword newStudentPasword :studentPasswords){
            if(newStudentPasword.getPassword().equals(password)&&newStudentPasword.getEmail().equals(email)&&newStudentPasword.getStudentID()==studentNR){
                int index = studentPasswords.indexOf(newStudent);  /* Student returnStudent = new Student();*/
                System.out.println(students.get(studentNR-1).getFirstName());
                return students.get(studentNR-1);
            }
        }
        return errorStudent;

         /* Student returnStudent = new Student();*/

        } //dit moet dan return student zijn --> kan nu nog niet door niet aangesloten DB

        //Deze methode moet checken als de email en het password ingevoerd
         //in studentlogin hierboven kloppen met een account in de DB, dit kan pas als de DB aangesloten is


    public void landlordMenu(){
        JRadioButton register = new JRadioButton("Register");
        JRadioButton login = new JRadioButton("Login");

        Object[] message = {"Do you want to register or to log in?",register, login};

        int option = JOptionPane.showConfirmDialog(null, message, "Landlord menu", JOptionPane.CANCEL_OPTION);

        if(register.isSelected()){landlordRegister();}
        if(login.isSelected()){landlordLogin();}
        if(option == JOptionPane.CANCEL_OPTION){menu();}

    } //Ook hier een exception hiervoor

    public void landlordRegister(){

        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JTextField email = new JTextField();
        JTextField telephoneNR = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
                "First name:", firstName,
                "Last name:", lastName,
                "Email:", email,
                "Telephone number:",telephoneNR,
                "Password:", password

        };

        int option1 = JOptionPane.showConfirmDialog(null, message, "Landlord register", JOptionPane.OK_CANCEL_OPTION);

        if(option1 ==JOptionPane.OK_OPTION){
            if(landlordPresent()==false){
                JOptionPane.showMessageDialog(null, "You have successfully added your profile!");
                //Methode voor checken van correct email?
                landlordOptionsMenu();
            }
            else{

                Object[] message2 ={"You are already in the system!", "Do you want to log in instead?"};
                int option2 = JOptionPane.showConfirmDialog(null, message2, "Error", JOptionPane.OK_CANCEL_OPTION);
                if(option2==JOptionPane.OK_OPTION){landlordLogin();}
                if(option2==JOptionPane.CANCEL_OPTION){landlordRegister();}
            }

        }
        if(option1 == JOptionPane.CANCEL_OPTION){landlordMenu();}
    } //Ook hier een exception hiervoor

    public boolean landlordPresent(){return true;} //methode die checkt als landlord aanwezig is in de DB

    public void landlordLogin(){

        Landlord errorLandlord = new Landlord("0", "0", "0", "0", "0");

        JTextField email = new JTextField();
        JTextField landlordNR = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
                "Email:", email,
                "Landlord ID: ",landlordNR,
                "Password:", password

        };

        int option1 = JOptionPane.showConfirmDialog(null, message, "Landlord login", JOptionPane.OK_CANCEL_OPTION);

        if(option1 ==JOptionPane.OK_OPTION){
            if(!landlordDatabaseCheck(email.getText(), password.getText(), Integer.parseInt(landlordNR.getText())).equals(errorLandlord)){
                JOptionPane.showMessageDialog(null,"You are successfully logged in!");
                landlordOptionsMenu();
            }
            else{

                Object[] message2 ={"The password and email are not correct!","Please try again!"};
                int option2 = JOptionPane.showConfirmDialog(null, message2, "Error", JOptionPane.OK_CANCEL_OPTION);
                if(option2==JOptionPane.OK_OPTION){landlordLogin();}
                if(option2==JOptionPane.CANCEL_OPTION){landlordMenu();}
            }

        }
        if(option1 == JOptionPane.CANCEL_OPTION){menu();}

    }

    public Landlord landlordDatabaseCheck(String email, String password, int landlordNR){

        LandlordPassword newLandlord = new LandlordPassword(email, password);
        Landlord errorLandlord = new Landlord("0", "0", "0", "0", "0");
        for(LandlordPassword newLandlordPasword :landlordPasswords){
            if(newLandlordPasword.getPassword().equals(password)&&newLandlordPasword.getEmail().equals(email)&&newLandlordPasword.getLandlordID()== landlordNR){
                int index = landlordPasswords.indexOf(newLandlord);  /* Student returnStudent = new Student();*/
                System.out.println(landlords.get(index-1).getName());
                return landlords.get(landlordNR-1);
            }
        }
        return errorLandlord;
        }



    public void studentOptionsMenu(Student student){
        JLabel welcome = new JLabel("Welcome to this energy conservation app "+student.getName()+"!");
        JLabel choose = new JLabel("Choose one option!");
        JRadioButtonMenuItem appliances = new JRadioButtonMenuItem("Adding, changing or deleting of appliances?");
        JRadioButtonMenuItem conservation = new JRadioButtonMenuItem("Energy conservation menu?");
        JRadioButtonMenuItem report = new JRadioButtonMenuItem("Energy consumption/conservation report?");


        Object[] message = {welcome,choose, appliances,conservation, report};

        int option = JOptionPane.showConfirmDialog(null, message, "Student actions menu", JOptionPane.CANCEL_OPTION);

        if(appliances.isSelected()){appliancesMenu(student);}
        if(conservation.isSelected()){conservationMenu();}
        if(report.isSelected()){studentReportMenu();}
        if(option == JOptionPane.CANCEL_OPTION){
            menu();
        }


    }

    public void appliancesMenu(Student student){


/*Change to grid layout.
        JPanel checkPanel = new JPanel(new GridLayout(0,1));

//Add check boxes to the content pane.

        JCheckBox actie1 = new JCheckBox("C++");
        JCheckBox actie2 = new JCheckBox("Java");
        JCheckBox actie3 = new JCheckBox("Perl");


// Create the label and add it to the content pane.

        JLabel textLabel = new JLabel("Select languages");
        checkPanel.add(textLabel);

// Handle item events for the check boxes.

        if(actie1.isSelected())

            textLabel.setText(actie1.getText() + " is selected");

        if(actie2.isSelected())

            textLabel.setText(actie2.getText() + " is selected");

        if(actie3.isSelected())

            textLabel.setText(actie3.getText() + " is selected");
        */



            JRadioButton add = new JRadioButton("Add an appliance");
            JRadioButton remove = new JRadioButton("Remove an existing appliance");
            JRadioButton change = new JRadioButton("Change an existing appliance");

            Object[] message = {add, remove, change};
            int option = JOptionPane.showConfirmDialog(null, message, "Appliance menu", JOptionPane.OK_CANCEL_OPTION);

            if(add.isSelected()){

                addApplianceKind(student);
                /*if (addAppliance().equals("OKE"))
                    JOptionPane.showMessageDialog(null, "Your appliance is added to the database!");
                    addAppliance();
                    studentOptionsMenu();

                if(addAppliance().equals("DUBBEL"))
                    JOptionPane.showMessageDialog(null, "Our database already contains your appliance! ");
                    appliancesMenu();

                if(addAppliance().equals("FOUT"))
                    JOptionPane.showMessageDialog(null, "The information you gave is not correct!");
                    appliancesMenu();*/
            }
            if(remove.isSelected()){
                removeAppliance();
            }
            if(change.isSelected()){
                changeAppliance();
            }
            if (option == JOptionPane.CANCEL_OPTION) {
            studentOptionsMenu(student);
            }


    }

    public boolean removeAppliance(){return true;}

    public void addApplianceKind(Student student){
            JRadioButton electricity = new JRadioButton("An appliance consuming electricity?");
            JRadioButton gas = new JRadioButton("An appliance consuming gas?");
            JRadioButton water = new JRadioButton("An appliance consuming water?");

            Object[] message = {electricity, gas, water};
            int option = JOptionPane.showConfirmDialog(null, message, "Which kind of appliance?", JOptionPane.OK_CANCEL_OPTION);

            if(electricity.isSelected()){addAppliance("Electricity", student);}
            if(gas.isSelected()){addAppliance("Gas", student);}
            if(water.isSelected()){addAppliance("Water", student);}
            if(option == JOptionPane.CANCEL_OPTION){appliancesMenu(student);}
    }
    public String addAppliance(String input, Student student){
            String nameString, consumptionString, efficiencyString, QRCodeString;
            JTextField name = new JTextField();
            JTextField consumption = new JTextField();
            JTextField efficiency = new JTextField();
            JTextField QRCode = new JTextField();

            if(input.equals("Gas")||input.equals("Electricity")){
                Object[] message ={"Name: ", name, "Efficiency: ", efficiency, "Consumption: ", consumption,"kWh", "QR-Code: ", QRCode };
            }
            else{
                Object[] message ={"Name: ", name, "Efficiency: ", efficiency, "Consumption: ", consumption+"m³", "QR-Code: ", QRCode };
            }

            Object[] message ={"Name: ", name, "Efficiency: ", efficiency, "Consumption: ", consumption, "QR-Code: ", QRCode };

            int option = JOptionPane.showConfirmDialog(null, message, "Add appliance menu", JOptionPane.OK_CANCEL_OPTION);


            nameString = name.getText();
            consumptionString = consumption.getText();
            efficiencyString = efficiency.getText();
            QRCodeString = QRCode.getText();



            return "OKE";
        }
    public boolean changeAppliance(){return true;}


    public void conservationMenu(){

    }
    public void studentReportMenu(){

    }

    public void landlordOptionsMenu(){
        JRadioButton persons = new JRadioButton("Adjusting student/contact person list?");
        JRadioButton consumption = new JRadioButton("Registering energy consumption?");
        JRadioButton report = new JRadioButton("Energy consumption/conservation report?");

        Object[] message = {"Choose one option", persons, consumption, report};

        int option = JOptionPane.showConfirmDialog(null, message, "Landlord actions menu", JOptionPane.OK_CANCEL_OPTION);

        if(persons.isSelected()){personsMenu();}
        if(consumption.isSelected()){consumptionMenu();}
        if(report.isSelected()){landlordReportMenu();}
        if(option == JOptionPane.CANCEL_OPTION){menu();}

    }

    public void personsMenu(){

    }
    public void consumptionMenu(){

    }
    public void landlordReportMenu(){

    }




    public static void main(String[] args){

    App app = new App();
    Student leon = new Student("Leon", "Vanhooren", "leon.vanhooren@ugent.be", "leoniscool");
    System.out.println(leon.getStudentID());
    StudentPassword leonPassword = new StudentPassword("leon.vanhooren@ugent.be", "leoniscool");
    Student milan = new Student("Milan", "Vissers", "milan.vissers@ugent.be", "milaniscool");
    StudentPassword milanPassword = new StudentPassword("milan.vissers@ugent.be", "milaniscool");

    Landlord hilde = new Landlord("Hilde", "Dooms", "hilde@vanhooren-dooms.be", "96549695", "hildeiscool");
    LandlordPassword hildePassword = new LandlordPassword("hilde@vanhooren-dooms.be", "hildeiscool");

    app.students.add(leon);
    app.studentPasswords.add(leonPassword);
    app.students.add(milan);
    app.studentPasswords.add(milanPassword);
    app.menu();

    }


        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


