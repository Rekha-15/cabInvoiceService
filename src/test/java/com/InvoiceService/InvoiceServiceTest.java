import org.junit.Test;

import junit.framework.Assert;

public class InvoiceServiceTest {

	@Test
    public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
        InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double totalFare = cabInvoiceGenerator.calculateFare(distance,time);
        System.out.println("Total Fare = " +totalFare);
        Assert.assertEquals(25, totalFare,0.0);
    }

	@Test
    public void whenGivenLessDistanceOrTimeShouldReturnMinimumFare() {
        InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        System.out.println("Minimum Fare = " +fare);
        Assert.assertEquals(5, fare,0.0);
    }

	@Test
    public void whenGivenMultipleRidesShouldReturnInvoiceSummary() {
        InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)};
        double totalFare = cabInvoiceGenerator.calculateTotalFare(rides);
        System.out.println("Total Fare = "+totalFare);
        Assert.assertEquals(30, totalFare,0.0);
    }
}