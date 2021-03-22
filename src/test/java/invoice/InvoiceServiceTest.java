package invoice;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;
    @Before
    public  void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalfare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateTotalFare(distance, time);
        Assert.assertEquals(25,totalFare,0.0);
    }
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceGenerator.calculateTotalFare(distance, time);
        Assert.assertEquals(5,totalFare,0.0);
    }
    @Test
    public void givenDistanceAndTImeWithMultipleRidesCount_ShouldReturnInvoiceSummary() {
        Ride[] ride1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(ride1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
    @Test
    public void givenUserId_ShouldReturn_InvoiceSummaryWithId() {
        InvoiceSummaryWithId[] summary1 = {new InvoiceSummaryWithId(1,30.2,1),
                new InvoiceSummaryWithId(2,53.5, 2)
        };
        int id = 1;
        InvoiceSummaryWithId summary = invoiceGenerator.invoiceList(summary1, id);
        InvoiceSummaryWithId expectedInvoiceSummary = new InvoiceSummaryWithId(1,30.2,1);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

}
