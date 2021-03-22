package invoice;

public class InvoiceGenerator {

    public enum Ride_Type {
        NORMAL_RIDE,PREMIUM_RIDE
    }

    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    private static final double MINIMUM_COST_PER_KM_PREMIUM_RIDE = 15;
    private static final int COST_PER_TIME_PREMIUM_RIDE = 2;
    private static final double MINIMUM_FARE_PREMIUM_RIDE = 20;

    public double calculateTotalFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare,MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalfare = 0;
        for (Ride ride:rides) {
            totalfare += calculateTotalFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length,totalfare);
    }

    public InvoiceSummaryWithId invoiceList(InvoiceSummaryWithId[] summary, int id) {
        InvoiceSummaryWithId result = null;
        for (InvoiceSummaryWithId summaryWithId : summary) {
            if (summaryWithId.getId() == id ) result = summaryWithId;
        }
        return result;
    }

    public double calculateTotalFare(double distance, int time, Ride_Type type) {
        double totalFare = 0;
        switch (type) {
            case NORMAL_RIDE:
                totalFare = Math.max(distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME, MINIMUM_FARE);
                break;
            case PREMIUM_RIDE:
                totalFare = Math.max(distance * MINIMUM_COST_PER_KM_PREMIUM_RIDE + time * COST_PER_TIME_PREMIUM_RIDE, MINIMUM_FARE_PREMIUM_RIDE);
                break;
        }
        return totalFare;
    }
}
