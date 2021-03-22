package invoice;

public class InvoiceSummaryWithId {
    public final double avgFare;
    public final int rides;
    public final double fare;
    private final int id;

    public InvoiceSummaryWithId(int rides, double fare, int id) {
        this.rides = rides;
        this.fare = fare;
        this.avgFare = this.fare/this.rides;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummaryWithId summary = (InvoiceSummaryWithId) o;
        return Double.compare(summary.avgFare, avgFare) == 0 && rides == summary.rides && Double.compare(summary.fare, fare) == 0 && id == summary.id;
    }
}
