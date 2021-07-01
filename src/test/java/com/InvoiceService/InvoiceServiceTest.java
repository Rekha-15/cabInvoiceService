package com.InvoiceService;

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
}
		
