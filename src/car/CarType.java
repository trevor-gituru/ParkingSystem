package car;

public class CarType {
	enum CarType1 {
		COMPACT,
		SUV;
	}
	private CarType1 type;

	public CarType(String ty){
		setType(ty);
	}
	
	public void setType(String type) {
		type = type.toUpperCase();
		switch (type) {
		case "COMPACT":
			this.type = CarType1.COMPACT;
			break;
		case "SUV":
			this.type = CarType1.SUV;
			break;
		default:
			this.type = null;
		}
	}
	
	public String getType() {
		switch (this.type) {
		case COMPACT:
			return "COMPACT";
		case SUV:
			return "SUV";
		default:
			return null;
		}
	}
}
