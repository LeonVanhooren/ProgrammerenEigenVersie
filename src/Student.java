import java.util.Objects;

public class Student {

    private String name, firstName, lastName, email, password;
    private int studentID;
    private static int id = 0;

    public Student(String firstName, String lastName, String email, String password){
        this.studentID = id +1;
        id++;
        this.name = firstName + " " + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Student(String email, String password){
        this.password = password;
        this.email = email;
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

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstName, lastName, email, password);
    }
}
