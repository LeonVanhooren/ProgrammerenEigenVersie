import javax.swing.*;
import java.util.ArrayList;


    public class App {
        private ArrayList<Student> students;
        private ArrayList<Landlord> landlords;
        private ArrayList<Building> buildings;
        private ArrayList<Owns> ownerships;
        private ArrayList<Contract> contracts;
        private ArrayList<Room> rooms;
        private ArrayList<Lease> leases;

        public App() {
            this.students = new ArrayList<>();
            this.landlords = new ArrayList<>();
            this.buildings = new ArrayList<>();
            this.ownerships = new ArrayList<>();
            this.contracts = new ArrayList<>();
            this.rooms = new ArrayList<>();
            this.leases = new ArrayList<>();


        }

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

        if(option1 ==JOptionPane.OK_OPTION){
            if(studentPresent()==false){
                JOptionPane.showMessageDialog(null, "You have successfully added your profile!");
                //Methode voor checken van correct email?
                studentOptionsMenu();

            }
            else{

                Object[] message2 ={"You are already in the system!", "Do you want to log in instead?"};
                int option2 = JOptionPane.showConfirmDialog(null, message2, "Error", JOptionPane.OK_CANCEL_OPTION);
                if(option2==JOptionPane.OK_OPTION){studentLogin();}
                if(option2==JOptionPane.CANCEL_OPTION){studentRegister();}
            }

        }
        if(option1 == JOptionPane.CANCEL_OPTION){studentMenu();}

    }

    public boolean studentPresent(){return false;} //methode die checkt als de student al in de DB zit

    public void studentLogin(){

        JTextField email = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
                "Email:", email,
                "Password:", password

        };

        int option1 = JOptionPane.showConfirmDialog(null, message, "Student login", JOptionPane.OK_CANCEL_OPTION);

        if(option1 ==JOptionPane.OK_OPTION){
            if(studentDatabaseCheck()==true){studentOptionsMenu();}
            else{

                Object[] message2 ={"The password and email are not correct!","Please try again!"};
                int option2 = JOptionPane.showConfirmDialog(null, message2, "Error", JOptionPane.OK_CANCEL_OPTION);
                if(option2==JOptionPane.OK_OPTION){studentLogin();}
                if(option2==JOptionPane.CANCEL_OPTION){studentMenu();}
            }

        }
        if(option1 == JOptionPane.CANCEL_OPTION){menu();}


    }

    public boolean studentDatabaseCheck(){return true;} //Deze methode moet checken als de email en het password ingevoerd
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


        JTextField email = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
                "Email:", email,
                "Password:", password

        };

        int option1 = JOptionPane.showConfirmDialog(null, message, "Landlord login", JOptionPane.OK_CANCEL_OPTION);

        if(option1 ==JOptionPane.OK_OPTION){
            if(landlordDatabaseCheck()==true){landlordOptionsMenu();}
            else{

                Object[] message2 ={"The password and email are not correct!","Please try again!"};
                int option2 = JOptionPane.showConfirmDialog(null, message2, "Error", JOptionPane.OK_CANCEL_OPTION);
                if(option2==JOptionPane.OK_OPTION){landlordLogin();}
                if(option2==JOptionPane.CANCEL_OPTION){landlordMenu();}
            }

        }
        if(option1 == JOptionPane.CANCEL_OPTION){menu();}

    }

    public boolean landlordDatabaseCheck(){return false;}



    public void studentOptionsMenu(){

        JRadioButton appliances = new JRadioButton("Adding, changing or deleting of appliances?");
        JRadioButton conservation = new JRadioButton("Energy conservation menu?");
        JRadioButton report = new JRadioButton("Energy consumption/conservation report?");


        Object[] message = {"Choose",appliances,conservation, report};

        int option = JOptionPane.showConfirmDialog(null, message, "Student actions menu", JOptionPane.CANCEL_OPTION);

        if(appliances.isSelected()){appliancesMenu();}
        if(conservation.isSelected()){conservationMenu();}
        if(report.isSelected()){studentReportMenu();}
        if(option == JOptionPane.CANCEL_OPTION){System.exit(0);}


    }

    public void appliancesMenu(){

    }
    public void conservationMenu(){

    }
    public void studentReportMenu(){

    }

    public void landlordOptionsMenu(){
        JRadioButton persons = new JRadioButton("Adjusting student/contact person list?");
        JRadioButton consumption = new JRadioButton("Registering energy consumption?");
        JRadioButton report = new JRadioButton("Energy consumption/conservation report?");

        Object[] message = {"Choose", persons, consumption, report};

        int option = JOptionPane.showConfirmDialog(null, message, "Landlord actions menu", JOptionPane.OK_OPTION);

        if(persons.isSelected()){personsMenu();}
        if(consumption.isSelected()){consumptionMenu();}
        if(report.isSelected()){landlordReportMenu();}
        if(option == JOptionPane.CANCEL_OPTION){System.exit(0);}

    }

    public void personsMenu(){

    }
    public void consumptionMenu(){

    }
    public void landlordReportMenu(){

    }




    public static void main(String[] args){

    App newApp = new App();
    newApp.menu();

    }



}


