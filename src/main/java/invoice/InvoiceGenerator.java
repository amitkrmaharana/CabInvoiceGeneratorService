package invoice;

public class InvoiceGenerator {

    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateTotalFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare,MINIMUM_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalfare = 0;
        for (Ride ride:rides) {
            totalfare += calculateTotalFare(ride.distance, ride.time);

        }
        return totalfare;
    }
}
