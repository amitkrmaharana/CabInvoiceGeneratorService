package invoice;

public class InvoiceSummary {

    protected   double averagefare;
    protected  int numOfrides;
    protected  double totalFare;

    public InvoiceSummary(int numOfrides, double totalFare) {
        this.numOfrides = numOfrides;
        this.totalFare = totalFare;
        this.averagefare = this.totalFare/this.numOfrides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return Double.compare(summary.averagefare, averagefare) == 0 && numOfrides == summary.numOfrides && Double.compare(summary.totalFare, totalFare) == 0 ;
    }

}
