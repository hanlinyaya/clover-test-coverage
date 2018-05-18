package test.com.wd.payroll.integration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import main.com.wd.payroll.integration.controller.PaymentController;
import main.com.wd.payroll.integration.exception.BadDataException;
import main.com.wd.payroll.integration.model.Payment;
import main.com.wd.payroll.integration.util.PaymentType;

public class PaymentControllerTest {

    @Test
    public void testInitPayment_true() {
        PaymentController pc = new PaymentController();
        Assert.assertTrue(pc.initPayment("abc"));
    }

    @Test
    public void testInitPayment_false() {
        PaymentController pc = new PaymentController();
        Assert.assertFalse(pc.initPayment("any"));
    }

    @Test(expected = BadDataException.class)
    public void testGetTotalPayment_nullPayments() {
        PaymentController pc = new PaymentController();
        pc.getTotalPayment(null);
    }

    @Test(expected = BadDataException.class)
    public void testGetTotalPayment_emptyPayments() {
        PaymentController pc = new PaymentController();
        pc.getTotalPayment(null);
    }

    @Test
    public void testGetTotalPayment_validPayments() {
        Payment firstPayment = new Payment();
        firstPayment.setPaymentType(PaymentType.DIRECT_DEPOSIT);
        firstPayment.setAmount(1);
        Payment secondPayment = new Payment();
        secondPayment.setPaymentType(PaymentType.DIRECT_DEPOSIT);
        secondPayment.setAmount(2);
        Payment thirdPayment = new Payment();
        thirdPayment.setPaymentType(PaymentType.CHECK);
        thirdPayment.setAmount(3);
        Payment fourthPayment = new Payment();
        fourthPayment.setPaymentType(PaymentType.CHECK);
        fourthPayment.setAmount(4);

        List<Payment> payments = new ArrayList<>();
        payments.add(firstPayment);
        payments.add(secondPayment);
        payments.add(thirdPayment);
        payments.add(fourthPayment);

        PaymentController pc = new PaymentController();
        Map<PaymentType, Integer> paymentToAmount = pc.getTotalPayment(payments);

        Assert.assertFalse(paymentToAmount.isEmpty());
        Assert.assertTrue(paymentToAmount.get(PaymentType.DIRECT_DEPOSIT).equals(3));
        Assert.assertTrue(paymentToAmount.get(PaymentType.CHECK).equals(7));
    }

}
