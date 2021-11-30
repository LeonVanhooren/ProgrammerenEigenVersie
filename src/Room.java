import java.util.ArrayList;

public class Room {
    private int roomNR, roomID, buildingID, studentID;
    private ArrayList<String> characteristics;
    private static int id = 0;
    private Building building;
    private Student student;

    public Room(Student student, Building building, int roomNR){
        this.roomID =id+1;
        id++;
        this.roomNR = roomNR;
        this.buildingID = building.getBuildingID();
        this.studentID = student.getStudentID();
        this.student = student;
        this.building = building;
        this.characteristics = new ArrayList<>();
    }

    public int getRoomNR() {
        return roomNR;
    }

    public void setRoomNR(int roomNR) {
        this.roomNR = roomNR;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(ArrayList<String> characteristics) {
        this.characteristics = characteristics;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}
