package id.ac.polinema.quiz2;

public class RegularLaundry extends LaundryOrder {
    
    private static final double PRICE_PER_KG = 6000.0;

    public RegularLaundry(String orderId, Customer customer, double weightKg) {
        super(orderId, customer, weightKg);
    }

    @Override
    public double calculatePrice() {
        return getWeightKg() * PRICE_PER_KG;
    }
}
