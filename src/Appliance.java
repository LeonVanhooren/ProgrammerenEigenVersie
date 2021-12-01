public class Appliance {

    private String qrCode, efficiency;
    private static int id = 0;
    private int applianceID;
    private Room room;

    public Appliance(Room room, String qrCode, String efficiency){
        this.room = room;
        this.qrCode = qrCode;
        this.efficiency = efficiency;
        this.applianceID = id+1;
        id++;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public int getApplianceID() {
        return applianceID;
    }

    public void setApplianceID(int applianceID) {
        this.applianceID = applianceID;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
