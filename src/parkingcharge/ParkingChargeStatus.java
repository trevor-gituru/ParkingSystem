package parkingcharge;

public class ParkingChargeStatus {
	enum ParkingChargeStatus1 {
		PARKED,
		LEFT;
	}
	private ParkingChargeStatus1 status;

	public ParkingChargeStatus(String st){
        setStatus(st);  
    }
	public void setStatus(String ty) {
		ty = ty.toUpperCase();
		switch (ty) {
		case "PARKED":
			this.status = ParkingChargeStatus1.PARKED;
			break;
		case "LEFT":
			this.status = ParkingChargeStatus1.LEFT;
			break;
		default:
			this.status = null;
		}
	}
	
	public String getStatus() {
		switch (this.status) {
		case PARKED:
			return "PARKED";
		case LEFT:
			return "LEFT";
		default:
			return null;
		}
	}
    
}
