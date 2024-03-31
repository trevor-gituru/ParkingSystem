package parkinglot;

public class ParkingLotType {
	enum ParkingLotType1 {
		HOURLY,
		DAILY;
	}
	private ParkingLotType1 type;

	public ParkingLotType(String st){
        setType(st);  
    }
	public void setType(String ty) {
		ty = ty.toUpperCase();
		switch (ty) {
		case "HOURLY":
			this.type = ParkingLotType1.HOURLY;
			break;
		case "DAILY":
			this.type = ParkingLotType1.DAILY;
			break;
		default:
			this.type = null;
		}
	}
	
	public String getType() {
		switch (this.type) {
		case HOURLY:
			return "HOURLY";
		case DAILY:
			return "DAILY";
		default:
			return null;
		}
	}
    
}