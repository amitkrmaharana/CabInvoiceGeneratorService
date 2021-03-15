package invoice;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}