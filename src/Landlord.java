import java.util.Objects;

public class Landlord {

    private String name, firstName, lastName, email,telephoneNR;
    private static int id = 0;
    private int landlordID;


    public Landlord(String firstName, String lastName, String email, String telephoneNR){
        this.name = firstName+" "+lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephoneNR = telephoneNR;
        this.landlordID = id+1;
        id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNR() {
        return telephoneNR;
    }

    public void setTelephoneNR(String telephoneNR) {
        this.telephoneNR = telephoneNR;
    }

    public int getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(int landlordID) {
        this.landlordID = landlordID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Landlord landlord = (Landlord) o;
        return landlordID == landlord.landlordID && name.equals(landlord.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, landlordID);
    }

    public String toString(){
        return this.name+", "+this.landlordID;
    }
}
