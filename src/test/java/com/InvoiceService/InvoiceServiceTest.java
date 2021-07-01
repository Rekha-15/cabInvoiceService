package com.InvoiceService;

import org.junit.Test;
import junit.framework.Assert;

public class InvoiceServiceTest {
	
	@Test
	public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
		
		InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
     // giving distance and time
     		//25 rs should be cost, so assigning local variable to this
     		//that is fare = LV
        double totalFare = cabInvoiceGenerator.calculateFare(distance,time);
        System.out.println("Total Fare = " +totalFare);
        Assert.assertEquals(25, totalFare,0.0);
 
    }
}
		
