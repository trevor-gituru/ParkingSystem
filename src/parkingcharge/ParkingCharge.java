package parkingcharge;

import money.Money;
import java.time.*;
import java.util.ArrayList;

public class ParkingCharge {
    private int chargeID;
    private String permitId;
    private String lotId;
    private ParkingChargeStatus state;
    private Instant[] incurred;
    private Money amount;
    
    public ParkingCharge(int id,String perm, String lotid, String stri){
        this.chargeID = id;
        setPermitId(perm);
        setLotId(lotid);
        setStatus(stri);
        incurred = new Instant[2];
        incurred[0] = Instant.now();
        
    }
    //setters
    public void setPermitId(String permit) {
    	permitId = permit;
    }
    public void setLotId(String lotid) {
    	lotId = lotid;
    }
    public void setAmount(ArrayList<Money> rates, String lotType, String carType) {
        this.incurred[1] = Instant.now();//Time left
        Duration dur = Duration.between(incurred[0], incurred[1]);
        long discount;
        //Check if one qualifies for the discount
        if (carType != "COMPACT"){
            discount =0L; 
        }
        long entry = rates.get(0).getCents();
        discount = (rates.get(3).getCents());
    	switch (lotType) {
            case "DAILY":
                long daysDiff = dur.toDays();
                long daily = rates.get(2).getCents();
                long total = entry + daily*daysDiff;
                amount = new Money(total-(total*discount)/100);
                break;
            case "HOURLY":
                long hoursDiff = dur.toHours();
                long hourly = rates.get(1).getCents();
                long tots = hourly*hoursDiff;
                amount = new Money(tots-(tots*discount)/100);
                break;
            default:
                amount = new Money(0L);
                break;
        }
    }
    public void setStatus(String stx){
        state = new ParkingChargeStatus(stx);
    }
    
    //getters
    public int getChargeId() {
    	return this.chargeID;
    }
    public String getPermitId() {
    	return this.permitId;
    }
    public int getLotId() {
        String LotIDstr = this.lotId.substring(3);
        int LotIDint = Integer.parseInt(LotIDstr);
    	return LotIDint;
    }
    public Money getAmount() {
    	return this.amount;
    }
    public String getStatus() {
    	return this.state.getStatus();
    }
    public LocalDate getIncurredFrom(){
        return incurred[0].atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public LocalDate getIncurredTo(){
        return incurred[1].atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public String toString() {
    	return "Parking Charge Transaction ID: "+ this.getChargeId()+ "\nPermit ID: "+ this.getPermitId()+
                "\nParking Lot ID: "+getLotId()+"\n"+this.getAmount().toString() + "\nParking State: "+ 
                this.getStatus() + "\nIncurred from: "+this.getIncurredFrom()+ "\nIncurred to: "+ 
                this.getIncurredTo() ;
    }
}
