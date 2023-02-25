import java.util.ArrayList;

public class Property implements Comparable<Property> {
    private String name;
    private ArrayList<?> list;
    private String totalPoints;
    private String price;
    private String no;
    private String lastUptadeDate;
    private String status;
    private String type;    //Daire,Villa,Mustakil Ev,Yazlik
    private String numberOfRooms;   //3 + 1, 5 + 1, 2 + 1, 5 + 2, 4 + 2, 4 + 1, 1 + 1
    private String propertySize; //m^2
    private String floor;
    private String ageOfBuilding;
    private String heatingType; //Isitma Yok,Kombi,Merkezi (Pay Olcer),Klima,Yerden Isitma,Jeotermal Isitma,Soba
    //Kat Kaloriferi,Isi Pompasi,Dogalgaz Sobasi,Merkezi
    private String totalFloors;
    private String creaditAvailability;
    private String furnishStatus;   //Esyali Degil,Esyali
    private String totalBathrooms;
    private String buildingType;
    private String condition;   //Ikinci El,Sifir
    private String usageCondition;  //Mulk Sahibi,Bos,Kiracili
    private String deed;    //Kat Mulkiyeti,Kat Irtifaki,Arsa
    private String fee;
    private String swap;
    private String front;
    private String rentIncome;
    private String fuelType;    //Komur-Odun,Dogalgaz,Akaryakit,Elektrik
    private String office;

    public String getSwap() {
        return swap;
    }

    public void setSwap(String swap) {
        this.swap = swap;
    }


    public ArrayList<?> getList() {
        return list;
    }

    public void setList(ArrayList<?> list) {
        this.list = list;
    }

    public Property(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getLastUptadeDate() {
        return lastUptadeDate;
    }

    public void setLastUptadeDate(String lastUptadeDate) {
        this.lastUptadeDate = lastUptadeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(String propertySize) {
        this.propertySize = propertySize;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getAgeOfBuilding() {
        return ageOfBuilding;
    }

    public void setAgeOfBuilding(String ageOfBuilding) {
        this.ageOfBuilding = ageOfBuilding;
    }

    public String getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(String heatingType) {
        this.heatingType = heatingType;
    }

    public String getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(String totalFloors) {
        this.totalFloors = totalFloors;
    }

    public String getCreaditAvailability() {
        return creaditAvailability;
    }

    public void setCreaditAvailability(String creaditAvailability) {
        this.creaditAvailability = creaditAvailability;
    }

    public String getFurnishStatus() {
        return furnishStatus;
    }

    public void setFurnishStatus(String furnishStatus) {
        this.furnishStatus = furnishStatus;
    }

    public String getTotalBathrooms() {
        return totalBathrooms;
    }

    public void setTotalBathrooms(String totalBathrooms) {
        this.totalBathrooms = totalBathrooms;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getUsageCondition() {
        return usageCondition;
    }

    public void setUsageCondition(String usageCondition) {
        this.usageCondition = usageCondition;
    }

    public String getDeed() {
        return deed;
    }

    public void setDeed(String deed) {
        this.deed = deed;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getRentIncome() {
        return rentIncome;
    }

    public void setRentIncome(String rentIncome) {
        this.rentIncome = rentIncome;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    /*
    public Property(String name, ArrayList<?> list) {
        this.name = name;
        this.list = list;
    }

    public Property(String name, String totalPoints,
                    String price, String no, String lastUptadeDate,
                    String status, String type, String numberOfRooms,
                    String propertySize, String floor, String ageOfBuilding,
                    String heatingType, String totalFloors, String creaditAvailability,
                    String furnishStatus, String totalBathrooms, String buildingType,
                    String condition, String usageCondition, String deed, String fee,
                    String front, String rentIncome, String fuelType, String office) {
        this.name = name;
        this.totalPoints = totalPoints;
        this.price = price;
        this.no = no;
        this.lastUptadeDate = lastUptadeDate;
        this.status = status;
        this.type = type;
        this.numberOfRooms = numberOfRooms;
        this.propertySize = propertySize;
        this.floor = floor;
        this.ageOfBuilding = ageOfBuilding;
        this.heatingType = heatingType;
        this.totalFloors = totalFloors;
        this.creaditAvailability = creaditAvailability;
        this.furnishStatus = furnishStatus;
        this.totalBathrooms = totalBathrooms;
        this.buildingType = buildingType;
        this.condition = condition;
        this.usageCondition = usageCondition;
        this.deed = deed;
        this.fee = fee;
        this.front = front;
        this.rentIncome = rentIncome;
        this.fuelType = fuelType;
        this.office = office;
    }

     */

    @Override
    public String toString() {
        return name;
    }

    public String calculateTotalPoints() {
        return totalPoints;
    }


    @Override
    public int compareTo(Property p) {
        return 0;
    }

}
