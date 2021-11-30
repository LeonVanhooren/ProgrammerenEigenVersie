public class Owns {

    private Building building;
    private Landlord landlord;

    public Owns(Building newBuilding, Landlord newlandlordID){
        this.building = newBuilding;
        this.landlord = newlandlordID;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public String toString(){
        String output = null;
        output = "The building on this adress: "+building.getAdress()+" is owned by the landlord with the name: "+landlord.getName();
        return output;
    }
}
