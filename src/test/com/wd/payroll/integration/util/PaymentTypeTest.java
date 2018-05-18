package test.com.wd.payroll.integration.util;

import org.junit.Assert;
import org.junit.Test;

import main.com.wd.payroll.integration.util.PaymentType;

public class PaymentTypeTest {

    @Test
    public void testPaymentType() {
        Assert.assertEquals("DIRECT_DEPOSIT", PaymentType.DIRECT_DEPOSIT.name());
        Assert.assertEquals("CHECK", PaymentType.CHECK.name());
    }
}
