package money;

public class Money {
    private long cent;
    
    public Money(long c){
        this.cent = c;
    }
    public double getDollars() {
    	return (double) cent / 100;
    }
    public long getCents() {
    	return cent;
    }
    public String toString() {
    	return String.format("Amount: %d cents or $%.2f", cent, this.getDollars());
    }
    
}
