package id.ac.polinema.quiz2;

public class ExpressLaundry extends LaundryOrder implements Deliverable{

    private static final double PRICE_PER_KG = 9000.0;
    private static final double DELIVERY_FEE = 5000.0;

    public ExpressLaundry (String orderId, Customer customer, double weightKg) {
        super(orderId, customer, weightKg);
    }

    @Override 
    public double calculatePrice() {
        return getWeightKg() * PRICE_PER_KG;
    }

    @Override 
    public double deliveryFee(){
        return DELIVERY_FEE;
    }
}
