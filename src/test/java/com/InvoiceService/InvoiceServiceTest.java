package com.InvoiceService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exception.InvoiceGeneratorException;
import utilily.InvoiceSummery;

public class InvoiceServiceTest {

	InvoiceGenerator invoiceGenerator;

	@Before
	public void setUp() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
		double distance = 3.0;
		int time = 7;
		InvoiceSummery invoiceSummary = invoiceGenerator.calculateFare(new Ride(distance, time, "NORMAL"));
		InvoiceSummery expectedInvoiceSummary = new InvoiceSummery(1, 37);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	@Test
	public void whenGivenLessDistanceOrTimeShouldReturnMinimumFare() {
		double distance = 0.01;
		int time = 1;
		InvoiceSummery invoiceSummary = invoiceGenerator.calculateFare(new Ride(distance, time, "NORMAL"));
		InvoiceSummery expectedInvoiceSummary = new InvoiceSummery(1, 5);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	@Test
	public void whenGivenMultipleRidesShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(3.0, 7, "NORMAL"), new Ride(0.01, 1, "NORMAL") };
		InvoiceSummery invoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummery expectedInvoiceSummary = new InvoiceSummery(rides.length, 38.1);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
	

	@Test
	public void givenUserId_ShouldReturnInvoiceSummary() throws InvoiceGeneratorException {
		String[] userId = { "user1", "user2", "user3" };
		Ride[][] rides = { { new Ride(5.0, 12, "NORMAL"), new Ride(2.5, 6, "NORMAL") },
				{ new Ride(3.0, 5, "NORMAL"), new Ride(0.01, 1, "NORMAL") },
				{ new Ride(10.0, 15, "NORMAL"), new Ride(2, 30, "NORMAL") } };
		invoiceGenerator.addRideToRepository(userId, rides);
		InvoiceSummery summary = invoiceGenerator.invoiceForUser(userId[2]);
		InvoiceSummery expectedInvoiceSummary = new InvoiceSummery(rides[2].length, 165.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
	
	@Test
    public void givenSameUserId_ShouldThrowException()
    {
        try
        {
            String[] userId = {"user1", "user1", "user3"};
            Ride[][] rides =
                    {{new Ride(5.0, 12, "NORMAL"), new Ride(2.5, 6, "NORMAL")},
                    {new Ride(3.0, 5, "NORMAL"), new Ride(0.01, 1, "NORMAL")},
                    {new Ride(10.0, 15, "NORMAL"), new Ride(2, 30, "NORMAL")}};
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(InvoiceGeneratorException.class);
            invoiceGenerator.addRideToRepository(userId, rides);
        }
        catch (InvoiceGeneratorException e)
        {
            e.printStackTrace();
        }
    }
	
	
	@Test
    public void givenPremiumAndNormalRideForUserId_ShouldReturnInvoiceSummary() throws InvoiceGeneratorException
    {
            String[] userId = {"user1", "user2", "user3"};
            Ride[][] rides =
                    {{new Ride(5.0, 12, "PREMIUM"), new Ride(2.5, 6, "NORMAL")},
                    {new Ride(3.0, 5, "PREMIUM"), new Ride(0.01, 1, "PREMIUM")},
                    {new Ride(10.0, 15, "NORMAL"), new Ride(2, 30, "PREMIUM")}};
            invoiceGenerator.addRideToRepository(userId, rides);
            InvoiceSummery summary = invoiceGenerator.invoiceForUser(userId[2]);
            InvoiceSummery expectedInvoiceSummary = new InvoiceSummery(rides[2].length, 205.0);
            Assert.assertEquals(expectedInvoiceSummary, summary);
    }
	
    
}