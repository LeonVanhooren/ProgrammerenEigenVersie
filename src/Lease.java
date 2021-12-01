public class Lease {
    private Student student;
    private Room room;
    private int studentID, roomID, roomNR;
    private Building building;


    public Lease(Student student, Room room){
        this.student = student;
        this.room = room;
        this.studentID = student.getStudentID();
        this.roomID = room.getRoomID();
        this.roomNR = room.getRoomNR();
        this.building = room.getBuilding();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomNR() {
        return roomNR;
    }

    public void setRoomNR(int roomNR) {
        this.roomNR = roomNR;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
