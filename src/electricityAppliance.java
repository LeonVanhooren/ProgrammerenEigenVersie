public class electricityAppliance extends Appliance{
    private int consumption;

    public electricityAppliance(Room room, String qrCode, String efficiency, int consumption) {
        super(room, qrCode, efficiency);
        this.consumption = consumption;
    }
}
